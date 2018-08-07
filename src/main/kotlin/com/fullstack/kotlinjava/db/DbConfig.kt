package com.fullstack.kotlinjava.db

import com.fullstack.kotlinjava.config.DbProps
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.name

class DbConfig {

    var database: Database = Database.connect(
            DbProps.url(),
            DbProps.driver(), DbProps.user(), DbProps.password())

    init {
        showDbInfo()
    }

    fun showDbInfo() {
        println("Database connected to : ${database.vendor} ${database.version}")
        println("Database Name : ${database.name}")
    }
}
