package jp.ac.it_college.std.s23012.messageboard.domain.model

import kotlinx.datetime.LocalDateTime
import java.lang.Thread

data class Message(
    val id: Long,
    val thread: Long,
    val user: Long,
    val message: String,
    val postedAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val deleted: Boolean
)
