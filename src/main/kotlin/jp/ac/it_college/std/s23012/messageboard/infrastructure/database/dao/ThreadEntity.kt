package jp.ac.it_college.std.s23012.messageboard.infrastructure.database.dao

import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import jp.ac.it_college.std.s23012.messageboard.domain.model.Thread

class ThreadEntity(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<ThreadEntity>(ThreadsTable)

    var title by ThreadsTable.title
    var createdAt by ThreadsTable.createdAt
    var updatedAt by ThreadsTable.updatedAt
    var deleted by ThreadsTable.deleted

    fun toThreadModel(): Thread {
        return Thread(
            id.value,
            title,
            createdAt,
            updatedAt,
            deleted
        )
    }

    fun updateFromThreadModel(model: Thread) {
        title = model.title
        updatedAt = model.updatedAt
        deleted = model.deleted
    }
}