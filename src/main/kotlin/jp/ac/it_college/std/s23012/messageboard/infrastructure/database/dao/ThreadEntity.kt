package jp.ac.it_college.std.s23012.messageboard.infrastructure.database.dao

import kotlinx.datetime.LocalDateTime
import jp.ac.it_college.std.s23012.messageboard.domain.model.Thread

data class ThreadEntity(
    val id: Long,
    val title: String,
    val createdAt: LocalDateTime
) {
    fun toModel(): Thread {
        return Thread(id, title, createdAt)
    }
}