package jp.ac.it_college.std.s23012.messageboard.domain.model

import kotlinx.datetime.LocalDateTime

data class ThreadWithUser(
    val id: Long,
    val title: String,
    val userId: Long,
    val userName: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val deleted: Boolean
)
