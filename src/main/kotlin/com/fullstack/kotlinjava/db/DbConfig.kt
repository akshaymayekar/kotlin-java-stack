package com.fullstack.kotlinjava.db

import mu.KLogging
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.name

class DbConfig {

    companion object : KLogging()

    var database: Database = Database.connect(
            DbProps.url(),
            DbProps.driver(), DbProps.user(), DbProps.password())

    init {
        showDbInfo()
    }

    fun showDbInfo() {
        logger.info { "Database connected to : ${database.vendor} ${database.version}" }
        logger.info { "Database Name : ${database.name}" }
    }
}
