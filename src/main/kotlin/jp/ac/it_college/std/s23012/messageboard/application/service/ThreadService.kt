//package jp.ac.it_college.std.s23012.messageboard.application.service
//
//import jp.ac.it_college.std.s23012.messageboard.domain.model.Thread
//import jp.ac.it_college.std.s23012.messageboard.domain.repository.ThreadRepository
//import kotlinx.datetime.Clock
//import org.springframework.stereotype.Service
//import kotlinx.datetime.LocalDateTime
//import kotlinx.datetime.TimeZone
//import kotlinx.datetime.toLocalDateTime
//
//@Service
//class ThreadService(
//    private val threadRepository: ThreadRepository
//) {
//    fun getList(): List<Thread> {
//        return threadRepository.findAll()
//    }
//
//    fun newPost(title: String, message: String, userId: Long): Long {
//        // スレッド作成のロジックを実装
//        // 新しいスレッドのIDを返す
//        return 0L // 仮のID、実際には作成したスレッドのIDを返す
//    }
//
//    fun updateTitle(threadId: Long, newTitle: String, userId: Long): Thread {
//        // スレッドのタイトル更新のロジックを実装
//        // 更新されたスレッドを返す
//        return Thread(threadId, newTitle, Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())) // 仮のスレッド、実際には更新されたスレッドを返す
//    }
//
//    fun delete(threadId: Long, userId: Long): Thread {
//        // スレッドの削除のロジックを実装
//        // 削除されたスレッドを返す
//        return Thread(threadId, "deleted title", Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())) // 仮のスレッド、実際には削除されたスレッドを返す
//    }
//}