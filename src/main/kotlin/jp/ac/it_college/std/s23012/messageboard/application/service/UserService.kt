package jp.ac.it_college.std.s23012.messageboard.application.service

import jp.ac.it_college.std.s23012.messageboard.domain.model.User
import jp.ac.it_college.std.s23012.messageboard.domain.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {
    fun register(viewName: String, email: String, password: String) {
        if (userRepository.existsByEmail(email)) {
            throw IllegalArgumentException("Email is already registered")
        }

        val encodedPassword = passwordEncoder.encode(password)
        val user = User(
            id = 1L,
            viewName = viewName,
            email = email,
            password = encodedPassword
        )
        userRepository.save(user)
    }

    fun find(userId: Long): User {
        return userRepository.findById(userId)
            ?: throw IllegalArgumentException("User not found")
    }
}
