package jp.ac.it_college.std.s23012.messageboard.infrastructure.database.dao

import ch.qos.logback.core.model.Model
import jp.ac.it_college.std.s23012.messageboard.domain.model.Message
import jp.ac.it_college.std.s23012.messageboard.infrastructure.database.dao.MessagesTable.updatedAt
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.toJavaLocalDateTime
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class MessageEntity(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<MessageEntity>(MessagesTable)

    var threadId by MessagesTable.threadId
    var userId by MessagesTable.userId
    var message by MessagesTable.message
    var postedAt by MessagesTable.postedAt
    var updatedAt by MessagesTable.updatedAt
    var deleted by MessagesTable.deleted

    fun toModel(): Message {
        return Message(
            id.value,
            threadId,
            userId,
            message,
            postedAt,
            updatedAt,
            deleted
        )
    }

    fun updateFromModel(model: Message) {
        threadId = model.thread
        userId = model.user
        message = model.message
        postedAt = model.postedAt
        updatedAt = model.updatedAt
        deleted = model.deleted
    }
}