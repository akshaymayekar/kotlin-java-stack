package com.fullstack.kotlinjava

import com.fullstack.kotlinjava.config.ApplicationInjectorModule
import com.google.inject.Guice
import mu.KotlinLogging
import spark.kotlin.port
import java.net.InetAddress

private val logger = KotlinLogging.logger {}

fun main(args: Array<String>) {
    Guice.createInjector(ApplicationInjectorModule())
    logger.info { "Welcome to Kotlin Java Fullstack" }
    logger.info { "Server started at ${getUrl()}" }
}

fun getUrl(): String {
    return "http://${InetAddress.getLocalHost().hostAddress}:${port()}"
}
