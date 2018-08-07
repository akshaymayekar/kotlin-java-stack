package com.fullstack.kotlinjava.controllers

import spark.Request
import spark.Response
import spark.Route
import spark.Spark.get

class HomeController {

    init {
        get(Paths.Root.INDEX, index())
        get(Paths.Root.PING, ping())
    }

    private fun ping() = Route { _: Request, _: Response -> "Pong" }

    private fun index() = Route { _, _ -> "Kotlin Java Fullstack application" }
}
