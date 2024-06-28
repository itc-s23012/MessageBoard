package jp.ac.it_college.std.s23012.messageboard.infrastructure.database.repository

import jp.ac.it_college.std.s23012.messageboard.domain.repository.UserRepository
import jp.ac.it_college.std.s23012.messageboard.infrastructure.database.dao.UserEntity
import jp.ac.it_college.std.s23012.messageboard.infrastructure.database.dao.UsersTable
import org.jetbrains.exposed.sql.transactions.transaction
import jp.ac.it_college.std.s23012.messageboard.domain.model.User
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.select
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl : UserRepository {
    override fun existsByEmail(email: String): Boolean = transaction {
        UserEntity.find { UsersTable.email eq email}.empty().not()
    }

    override fun save(user: User): User = transaction {
        val userEntity = UserEntity.new {
            viewName = user.viewName
            email = user.email
            password = user.password
        }
        user.copy(id = userEntity.id.value)
    }

    override fun findById(id: Long): User? = transaction {
       UserEntity.findById(id)?.let {
           User(it.id.value, it.viewName, it.email, it.password)
       }
    }

    override fun findByEmail(email: String): User? = transaction{
        UsersTable.select { UsersTable.email eq email }
            .map { it.toUser() }
            .singleOrNull()
    }

    private fun ResultRow.toUser() = User(
        id = this[UsersTable.id].value,
        viewName = this[UsersTable.viewName],
        email = this[UsersTable.email],
        password = this[UsersTable.password]
    )
}