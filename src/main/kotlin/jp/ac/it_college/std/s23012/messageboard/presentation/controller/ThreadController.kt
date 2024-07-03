package jp.ac.it_college.std.s23012.messageboard.presentation.controller

import jp.ac.it_college.std.s23012.messageboard.application.service.ThreadService
import jp.ac.it_college.std.s23012.messageboard.application.service.security.MessageBoardUserDetails
import jp.ac.it_college.std.s23012.messageboard.presentation.form.*
import kotlinx.datetime.LocalDateTime
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/threads")
@CrossOrigin
class ThreadController(
    private val service: ThreadService
) {
    @GetMapping("/list")
    fun getList(): GetThreadListResponse {
        val threadList = service.getList().map { ThreadInfo(it) }
        return GetThreadListResponse(threadList)
    }

    @PostMapping("/create")
    fun create(
        @RequestBody body: PostThreadRequest,
        @AuthenticationPrincipal user: MessageBoardUserDetails
    ): CreatedThreadResponse {
        val newId = service.newPost(body.title, body.message, user.id)
        return CreatedThreadResponse(newId)
    }

    @PutMapping("/update/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody body: PutThreadUpdateRequest,
        @AuthenticationPrincipal user: MessageBoardUserDetails
    ): ThreadUpdateResponse {
        val thread = service.updateTitle(id, body.title, user.id)
        return thread.run { ThreadUpdateResponse(thread.id, thread.title) }
    }

    @DeleteMapping("/delete/{id}")
    fun deleteThread(
        @PathVariable id: Long,
        @AuthenticationPrincipal user: MessageBoardUserDetails
    ): ThreadDeleteResponse {
        val result = service.delete(id, user.id)
        return ThreadDeleteResponse(result.id ?: 0, result.title, result.updatedAt ?: LocalDateTime.MIN)
    }
}