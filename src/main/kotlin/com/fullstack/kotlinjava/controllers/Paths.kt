package com.fullstack.kotlinjava.controllers

class Paths {
    object Root {
        const val INDEX = "/"
        const val PING = "/ping"
    }

    object Users {
        const val INDEX = "/users"
        const val USER_ID = "$INDEX/:id"
        const val USER_ACTIVE = "$INDEX/active"
    }
}
