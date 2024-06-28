package jp.ac.it_college.std.s23012.messageboard.domain.model

import kotlinx.datetime.LocalDateTime

data class MessageWithThread(
    val id: Long,
    val threadId: Long,
    val userId: Long,
    val message: String,
    val postedAt: LocalDateTime?,
    val updatedAt: LocalDateTime?,
    val deleted: Boolean?,
    val thread: Thread?
)