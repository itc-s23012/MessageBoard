//package jp.ac.it_college.std.s23012.messageboard.infrastructure.database.repository
//
//import jp.ac.it_college.std.s23012.messageboard.domain.model.Message
//import jp.ac.it_college.std.s23012.messageboard.domain.repository.MessageRepository
//import jp.ac.it_college.std.s23012.messageboard.infrastructure.database.dao.MessageEntity
//import jp.ac.it_college.std.s23012.messageboard.infrastructure.database.dao.MessagesTable
//import org.jetbrains.exposed.sql.insertAndGetId
//import org.jetbrains.exposed.sql.select
//import org.jetbrains.exposed.sql.transactions.transaction
//import org.jetbrains.exposed.sql.update
//import org.springframework.stereotype.Repository
//
//@Repository
//class MessageRepositoryImpl : MessageRepository {
//    override fun findByThreadId(threadId: Long): List<Message> = transaction {
//        MessagesTable.select { MessagesTable.threadId eq threadId }
//            .map {
//                MessageEntity(
//                    id = it[MessagesTable.id].value,
//                    threadId = it[MessagesTable.threadId],
//                    userId = it[MessagesTable.userId],
//                    message = it[MessagesTable.message],
//                    postedAt = it[MessagesTable.postedAt],
//                    updatedAt = it[MessagesTable.updatedAt],
//                    deleted = it[MessagesTable.deleted]
//                ).toMessage()
//            }
//    }
//
//    override fun findById(id: Long): Message? = transaction {
//        MessagesTable.select { MessagesTable.id eq id }
//            .map {
//                MessageEntity(
//                    id = it[MessagesTable.id].value,
//                    threadId = it[MessagesTable.threadId],
//                    userId = it[MessagesTable.userId],
//                    message = it[MessagesTable.message],
//                    postedAt = it[MessagesTable.postedAt],
//                    updatedAt = it[MessagesTable.updatedAt],
//                    deleted = it[MessagesTable.deleted]
//                ).toMessage()
//            }
//            .singleOrNull()
//    }
//
//    override fun create(message: Message): Message = transaction {
//        val id = MessagesTable.insertAndGetId {
//            it[threadId] = message.threadId
//            it[userId] = message.userId
//            it[this.message] = message.message
//            it[postedAt] = message.postedAt
//            it[updatedAt] = message.updatedAt
//            it[deleted] = message.deleted
//        }.value
//        message.copy(id = id)
//    }
//
//    override fun update(message: Message): Message = transaction {
//        MessagesTable.update({ MessagesTable.id eq message.id }) {
//            it[threadId] = message.threadId
//            it[userId] = message.userId
//            it[this.message] = message.message
//            it[updatedAt] = message.updatedAt
//            it[deleted] = message.deleted
//        }
//        message
//    }
//
//    override fun deleteById(id: Long) {
//        MessagesTable.update({ MessagesTable.id eq id }) {
//            it[deleted] = true
//        }
//    }
//}