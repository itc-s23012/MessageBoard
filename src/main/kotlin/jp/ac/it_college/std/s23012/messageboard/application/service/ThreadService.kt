package jp.ac.it_college.std.s23012.messageboard.application.service

import jp.ac.it_college.std.s23012.messageboard.domain.repository.ThreadRepository
import org.springframework.stereotype.Service

@Service
class ThreadService(
    private val threadRepository: ThreadRepository
) {
    fun getList(): List<Thread> {
        return threadRepository.findAll()
    }

    fun getDetails(id: Long): Thread {
        return threadRepository.findById(id)
    }

    fun newPost(title: String, message: String, userId: Long): Long {
        return threadRepository.save(title, message, userId)
    }

    fun updateTitle(id: Long, title: String, userId: Long): Thread {
        return threadRepository.updateTitle(id, title, userId)
    }

    fun delete(id: Long, userId: Long): Thread {
        return threadRepository.delete(id, userId)
    }
}