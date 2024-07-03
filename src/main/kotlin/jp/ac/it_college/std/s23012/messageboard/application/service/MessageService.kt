package jp.ac.it_college.std.s23012.messageboard.application.service

import jp.ac.it_college.std.s23012.messageboard.domain.model.Message
import jp.ac.it_college.std.s23012.messageboard.domain.repository.MessageRepository
import org.springframework.stereotype.Service

@Service
class MessageService(
    private val messageRepository: MessageRepository
) {
    fun getListByThread(threadId: Long): List<Message> {
        return messageRepository.findByThreadId(threadId)
    }

    fun newPost(threadId: Long, message: String, userId: Long): Message {
        return messageRepository.save(threadId, message, userId)
    }

    fun updateMessage(id: Long, message: String, userId: Long): Message {
        return messageRepository.update(id, message, userId)
    }

    fun deleteMessage(id: Long, userId: Long): Message {
        return messageRepository.delete(id, userId)
    }
}