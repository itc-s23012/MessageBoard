//package jp.ac.it_college.std.s23012.messageboard.application.service
//
//import jp.ac.it_college.std.s23012.messageboard.domain.model.Message
//import jp.ac.it_college.std.s23012.messageboard.domain.repository.MessageRepository
//import jp.ac.it_college.std.s23012.messageboard.domain.repository.ThreadRepository
//import jp.ac.it_college.std.s23012.messageboard.domain.repository.UserRepository
//import kotlinx.datetime.Clock
//import kotlinx.datetime.TimeZone
//import kotlinx.datetime.toLocalDateTime
//import org.springframework.stereotype.Service
//
//@Service
//class MessageService(
//    private val messageRepository: MessageRepository,
//    private val threadRepository: ThreadRepository,
//    private val userRepository: UserRepository
//) {
//    fun getListByThread(threadId: Long): List<Message> {
//        return messageRepository.findByThreadId(threadId)
//    }
//
//    fun newPost(threadId: Long, message: String, userId: Long): Long {
//        val now = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
//        val user = userRepository.findById(userId) ?: throw IllegalStateException("User not found")
//        val thread = threadRepository.findById(threadId) ?: throw IllegalArgumentException("Thread not found")
//        val newMessage = Message(0, threadId, user.id, message, now, now, false, thread)
//        val createdMessage = messageRepository.create(newMessage)
//        return createdMessage.id ?: throw IllegalStateException("Failed to create message")
//    }
//
//    fun updateMessage(id: Long, message: String, userId: Long): Message {
//        val existingMessage = messageRepository.findById(id) ?: throw IllegalArgumentException("Message not found")
//        if (existingMessage.userId != userId) {
//            throw UnauthorizedOperationException("You are not authorized to update this message.")
//        }
//        val updatedMessage = existingMessage.copy(message = message, updatedAt = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()))
//        return messageRepository.update(updatedMessage) ?: throw IllegalStateException("Failed to update message")
//    }
//
//    fun deleteMessage(id: Long, userId: Long): Message {
//        val existingMessage = messageRepository.findById(id) ?: throw IllegalArgumentException("Message not found")
//        if (existingMessage.userId != userId) {
//            throw UnauthorizedOperationException("You are not authorized to delete this message.")
//        }
//        val deletedMessage = existingMessage.copy(deleted = true, updatedAt = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()))
//        return messageRepository.update(deletedMessage) ?: throw IllegalStateException("Failed to delete message")
//    }
//    class UnauthorizedOperationException(message: String) : RuntimeException(message)
//}