package jp.ac.it_college.std.s23012.messageboard.domain.model

import kotlinx.datetime.LocalDateTime

data class Thread(
    val id: Long,
    val title: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val deleted: Boolean
)
