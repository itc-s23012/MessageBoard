package jp.ac.it_college.std.s23012.messageboard.infrastructure.database.dao

import jp.ac.it_college.std.s23012.messageboard.domain.model.User
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable

class UserEntity(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<UserEntity>(UsersTable)

    var viewName by UsersTable.viewName
    var email by UsersTable.email
    var password by UsersTable.password

    fun toDomain() = User(
        id.value,
        viewName,
        email,
        password
    )
}
