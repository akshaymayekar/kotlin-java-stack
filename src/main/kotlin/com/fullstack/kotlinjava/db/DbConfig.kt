package com.fullstack.kotlinjava.db

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.name

class DbConfig {

    var database: Database = Database.connect(
            "jdbc:mysql://localhost:3306/kotlin_java_stack",
            "com.mysql.jdbc.Driver", "root", "")

    init {
        showDbInfo()
    }

    fun showDbInfo() {
        println("Database connected to : ${database.vendor} ${database.version}")
        println("Database Name : ${database.name}")
    }
}