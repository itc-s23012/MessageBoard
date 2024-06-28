package jp.ac.it_college.std.s23012.messageboard.domain.model

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

data class Message(
    val id: Long = 0,
    val threadId: Long,
    val userId: Long,
    val message: String,
    val postedAt: LocalDateTime = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()),
    var updatedAt: LocalDateTime = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()),
    var deleted: Boolean = false,
    val thread: Thread? = null
)
