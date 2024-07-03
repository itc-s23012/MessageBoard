package jp.ac.it_college.std.s23012.messageboard.domain.repository

interface ThreadRepository {
    fun findAll(): List<Thread>
    fun findById(id: Long): Thread
    fun save(title: String, message: String, userId: Long): Long
    fun updateTitle(id: Long, title: String, userId: Long): Thread
    fun delete(id: Long, userId: Long): Thread
}
