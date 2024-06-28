package jp.ac.it_college.std.s23012.messageboard.domain.repository

import jp.ac.it_college.std.s23012.messageboard.domain.model.User

interface UserRepository {
    fun existsByEmail(email: String): Boolean
    fun save(user: User): User
    fun findById(id: Long): User?
    fun findByEmail(email: String): User?
}

