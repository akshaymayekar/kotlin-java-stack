package com.fullstack.kotlinjava.config

import java.io.File

object ResourceLoader {

    val environment = "development"

    fun load(): File {
        val uri = ResourceLoader::class.java.classLoader
                .getResource("$environment.properties").toURI()
        return File(uri)
    }
}
