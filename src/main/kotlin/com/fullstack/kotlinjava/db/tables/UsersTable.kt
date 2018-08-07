package com.fullstack.kotlinjava.db.tables

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object UsersTable : Table("users") {
    val id: Column<Int> = integer("id").autoIncrement().primaryKey()
    val name: Column<String> = varchar("name", 25)
    val password: Column<String> = varchar("password", 25)
    val active: Column<Boolean> = bool("active")

}
