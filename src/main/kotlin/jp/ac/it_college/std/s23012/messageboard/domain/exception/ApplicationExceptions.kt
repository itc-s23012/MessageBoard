package jp.ac.it_college.std.s23012.messageboard.domain.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class ThreadNotFoundException(override val message: String) : RuntimeException(message)

@ResponseStatus(HttpStatus.CONFLICT)
class ThreadIdAlreadyUsedException(override val message: String) : RuntimeException(message)

@ResponseStatus(HttpStatus.BAD_REQUEST)
class MessagePostingException(override val message: String = "メッセージの投稿時にエラーが発生しました") : RuntimeException(message)

@ResponseStatus(HttpStatus.CONFLICT)
class MessageNotFoundException(override val message: String) : RuntimeException(message)