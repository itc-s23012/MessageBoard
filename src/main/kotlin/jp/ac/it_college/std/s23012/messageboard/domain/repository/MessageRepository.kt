package jp.ac.it_college.std.s23012.messageboard.domain.repository

import jp.ac.it_college.std.s23012.messageboard.domain.model.Message

interface MessageRepository {
    fun findByThreadId(threadId: Long): List<Message>
    fun save(threadId: Long, message: String, userId: Long): Message
    fun update(id: Long, message: String, userId: Long): Message
    fun delete(id: Long, userId: Long): Message
}
