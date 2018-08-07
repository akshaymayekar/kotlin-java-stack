package com.fullstack.kotlinjava

import com.fullstack.kotlinjava.config.ApplicationInjectorModule
import com.google.inject.Guice
import spark.kotlin.port

fun main(args: Array<String>) {
    Guice.createInjector(ApplicationInjectorModule())
    println("Welcome to Kotlin Java Fullstack")
    println("Server started at http://localhost:${port()}")
}
