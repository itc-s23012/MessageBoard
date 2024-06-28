package jp.ac.it_college.std.s23012.messageboard.infrastructure.database.dao

import jp.ac.it_college.std.s23012.messageboard.domain.model.Thread
import kotlinx.datetime.LocalDateTime
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

object ThreadsTable : Table("threads") {
    val id = long("id").autoIncrement()
    val title = varchar("title", 255)
    val createdAt = datetime("created_at")

    override val primaryKey = PrimaryKey(id)

    fun selectAll(): List<ResultRow> {
        return ThreadsTable.selectAll().toList()
    }

    fun ResultRow.toModel(): Thread {
        return Thread(
            id = this[ThreadsTable.id],
            title = this[ThreadsTable.title],
            createdAt = this[ThreadsTable.createdAt]
        )
    }
}