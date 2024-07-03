package jp.ac.it_college.std.s23012.messageboard.infrastructure.database.repository

import jp.ac.it_college.std.s23012.messageboard.domain.model.Message
import jp.ac.it_college.std.s23012.messageboard.domain.repository.MessageRepository
import jp.ac.it_college.std.s23012.messageboard.infrastructure.database.dao.MessagesTable
import jp.ac.it_college.std.s23012.messageboard.infrastructure.database.dao.UserEntity.Companion.findById
import kotlinx.datetime.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update
import org.springframework.stereotype.Repository

@Repository
class MessageRepositoryImpl : MessageRepository {
    override fun findByThreadId(threadId: Long): List<Message> {
        return transaction {
            MessagesTable.select(listOf(MessagesTable.threadId eq threadId))
                .map { row ->
                    Message(
                        id = row[MessagesTable.id].value,
                        user = row[MessagesTable.userId],
                        message = row[MessagesTable.message],
                        postedAt = row[MessagesTable.postedAt],
                        updatedAt = row[MessagesTable.updatedAt],
                        deleted = row[MessagesTable.deleted].toBoolean
                    )
                }
        }
    }

    override fun save(threadId: Long, message: String, userId: Long): Message {
        val messageId = transaction {
            MessagesTable.insertAndGetId { row ->
                row[MessagesTable.threadId] = threadId
                row[MessagesTable.userId] = userId
                row[MessagesTable.message] = message
                row[MessagesTable.postedAt] = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
                row[MessagesTable.updatedAt] = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
                row[MessagesTable.deleted] = false
            }
        }
        return transaction {
            MessagesTable.select { MessagesTable.id eq messageId }
                .map { row ->
                    Message(
                        id = row[MessagesTable.id].value,
                        user = row[MessagesTable.userId],
                        message = row[MessagesTable.message],
                        postedAt = row[MessagesTable.postedAt],
                        updatedAt = row[MessagesTable.updatedAt],
                        deleted = row[MessagesTable.deleted]
                    )
                }.firstOrNull() ?: throw IllegalArgumentException("Failed to retrieve saved message")
        }
    }

    override fun update(id: Long, message: String, userId: Long): Message {
        val updateRows = transaction {
            MessagesTable.update({ MessagesTable.id eq id }) {
                it[MessagesTable.message] = message
                it[MessagesTable.updatedAt] = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
            }
        }
        if (updateRows > 0) {
            return transaction {
                MessagesTable.select { MessagesTable.id eq id }
                    .map { row ->
                        Message(
                            id = row[MessagesTable.id].value,
                            user = row[MessagesTable.userId],
                            message = row[MessagesTable.message],
                            postedAt = row[MessagesTable.postedAt],
                            updatedAt = row[MessagesTable.updatedAt],
                            deleted = row[MessagesTable.deleted]
                        )
                    }.firstOrNull() ?: throw IllegalArgumentException("Failed to retrieve updated message")
            }
        } else {
            throw IllegalArgumentException("Failed to update message with id $id")
        }
    }

    override fun delete(id: Long, userId: Long): Message {
        val deletedMessage = findById(id) ?: throw IllegalArgumentException("Message not found for id $id")

        val deletedRows = transaction {
            MessagesTable.deleteWhere { MessagesTable.id eq id }
        }
        if (deletedRows > 0) {
            return deletedMessage
        } else {
            throw IllegalArgumentException("Failed to delete message with id $id")
        }
    }

    private fun findById(id: Long): Message? {
        return transaction {
            MessagesTable.select { MessagesTable.id eq id}
                .map { row ->
                    Message(
                        id = row[MessagesTable.id].value,
                        user = row[MessagesTable.userId],
                        message = row[MessagesTable.message],
                        postedAt = row[MessagesTable.postedAt],
                        updatedAt = row[MessagesTable.updatedAt],
                        deleted = row[MessagesTable.deleted]
                    )
                }.firstOrNull()
        }
    }
}