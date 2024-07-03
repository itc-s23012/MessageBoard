package jp.ac.it_college.std.s23012.messageboard.infrastructure.database.dao

import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

object MessagesTable : LongIdTable("messages") {
    val threadId = long("thread_id").index()
    val userId = long("user_id").index()
    val message = text("message")
    val postedAt = datetime("posted_at")
    val updatedAt = datetime("updated_at")
    val deleted = bool("deleted").default(false)
}