package jp.ac.it_college.std.s23012.messageboard.domain.repository

import jp.ac.it_college.std.s23012.messageboard.domain.model.Message
import jp.ac.it_college.std.s23012.messageboard.domain.model.Thread
import jp.ac.it_college.std.s23012.messageboard.domain.model.User
import kotlinx.datetime.LocalDateTime

interface MessageRepository {
    fun findByThreadId(threadId: Long): List<Message>
    fun findById(id: Long): Message?
    fun create(message: Message): Message
    fun update(message: Message): Message
    fun deleteById(id: Long)
}
