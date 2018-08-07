package com.fullstack.kotlinjava.db.repositories

import com.fullstack.kotlinjava.db.tables.UsersTable
import com.fullstack.kotlinjava.models.User
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class UserRepository {

    val createNewUser = { user: User ->
        transaction {
            val newUserId: Int = UsersTable.insert {
                it[name] = user.name
                it[password] = user.password
                it[active] = user.active
            }.generatedKey as Int
            userById(newUserId)
        }
    }

    val updateUser = { id: Int, user: User ->
        transaction {
            val isUserUpdated: Int = UsersTable.update({ UsersTable.id eq id }) {
                it[name] = user.name
                it[password] = user.password
                it[active] = user.active
            }
            isUserUpdated == 1
        }
    }

    val deleteUser = { id: Int ->
        transaction {
            val deleted = UsersTable.deleteWhere { UsersTable.id eq id }
            deleted == 1
        }
    }

    val allUsers = {
        transaction {
            UsersTable.selectAll().map {
                User(it[UsersTable.id], it[UsersTable.name], it[UsersTable.password], it[UsersTable.active])
            }
        }
    }

    val activeUsers = {
        transaction {
            UsersTable.select { UsersTable.active eq true }.map {
                User(it[UsersTable.id], it[UsersTable.name], it[UsersTable.password], it[UsersTable.active])
            }
        }
    }

    val userById = { id: Int ->
        transaction {
            val userList = UsersTable.select { UsersTable.id eq id }.map {
                User(it[UsersTable.id], it[UsersTable.name], it[UsersTable.password], it[UsersTable.active])
            }
            if (userList.isEmpty()) {
                return@transaction "No user found"
            }
            userList[0]
        }
    }
}
