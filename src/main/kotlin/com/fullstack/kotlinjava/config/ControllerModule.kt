package com.fullstack.kotlinjava.config

import com.fullstack.kotlinjava.controllers.HomeController
import com.fullstack.kotlinjava.controllers.UserController
import com.google.inject.AbstractModule

class ControllerModule : AbstractModule() {

    override fun configure() {
        bind(HomeController::class.java).asEagerSingleton()
        bind(UserController::class.java).asEagerSingleton()
    }
}
