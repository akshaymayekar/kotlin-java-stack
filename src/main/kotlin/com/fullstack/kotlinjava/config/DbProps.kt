package com.fullstack.kotlinjava.config

import java.io.FileReader
import java.util.Properties

object DbProps {

    private val properties = Properties()

    init {
        properties.load(FileReader(ResourceLoader.load()))
    }

    fun url(): String = properties.getProperty("database.url", "")

    fun driver(): String = properties.getProperty("database.driver", "")

    fun user(): String = properties.getProperty("database.user", "")

    fun password(): String = properties.getProperty("database.password", "")
}
