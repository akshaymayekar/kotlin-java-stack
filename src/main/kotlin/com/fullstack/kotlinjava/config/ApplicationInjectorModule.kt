package com.fullstack.kotlinjava.config

import com.fullstack.kotlinjava.db.DbConfig
import com.fullstack.kotlinjava.db.repositories.UserRepository
import com.google.inject.AbstractModule

class ApplicationInjectorModule : AbstractModule() {

    override fun configure() {
        bind(DbConfig::class.java).asEagerSingleton()
        bind(UserRepository::class.java)

        install(ControllerModule())
    }
}
