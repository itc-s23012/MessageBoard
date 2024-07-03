package jp.ac.it_college.std.s23012.messageboard.infrastructure.database.dao

import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

object ThreadsTable : LongIdTable("threads") {
    val title = varchar("title", 255)
    val createdAt = datetime("created_at")
    val updatedAt = datetime("updated_at")
    val deleted = bool("deleted").default(false)
}