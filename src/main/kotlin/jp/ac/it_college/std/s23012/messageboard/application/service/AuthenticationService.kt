//package jp.ac.it_college.std.s23012.messageboard.application.service
//
//import jp.ac.it_college.std.s23012.messageboard.domain.model.User
//import jp.ac.it_college.std.s23012.messageboard.domain.repository.UserRepository
//import org.springframework.security.core.userdetails.UsernameNotFoundException
//import org.springframework.security.crypto.password.PasswordEncoder
//import org.springframework.stereotype.Service
//
//@Service
//class AuthenticationService(
//    private val userRepository: UserRepository,
//    private val passwordEncoder: PasswordEncoder
//) {
//
//    fun registerUser(email: String, password: String, viewName: String): Long {
//        // Check if user already exists
//        if (userRepository.findByEmail(email) != null) {
//            throw IllegalStateException("User with email $email already exists")
//        }
//
//        // Encrypt password
//        val hashedPassword = passwordEncoder.encode(password)
//
//        // Create user
//        val newUser = User(
//            id = 0, // or generate ID as per your application logic
//            viewName = viewName,
//            email = email,
//            password = hashedPassword
//        )
//
//        // Save user in repository
//        val createdUser = userRepository.save(newUser)
//
//        return createdUser.id ?: throw IllegalStateException("Failed to create user")
//    }
//
//    fun loginUser(email: String, password: String): User {
//        val user = userRepository.findByEmail(email)
//            ?: throw UsernameNotFoundException("User not found with email: $email")
//
//        if (!passwordEncoder.matches(password, user.password)) {
//            throw IllegalArgumentException("Invalid password")
//        }
//
//        return user
//    }
//
//    fun generateToken(user: User): String {
//        // Logic to generate and return authentication token (e.g., JWT) can be implemented here
//        // Example:
//        // val token = jwtTokenUtil.generateToken(user)
//        // return token
//        throw NotImplementedError("Token generation logic not implemented")
//    }
//}