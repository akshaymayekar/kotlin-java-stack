package com.fullstack.kotlinjava.controllers

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fullstack.kotlinjava.db.repositories.UserRepository
import com.fullstack.kotlinjava.models.User
import org.eclipse.jetty.http.HttpStatus
import spark.Route
import spark.Spark.*
import javax.inject.Inject

class UserController {

    @Inject
    private lateinit var userRepository: UserRepository
    private val mapper = jacksonObjectMapper()

    init {
        get(Paths.Users.INDEX, all())
        get(Paths.Users.USER_ACTIVE, activeUsers())
        get(Paths.Users.USER_ID, userById())

        post(Paths.Users.INDEX, create())
        put(Paths.Users.USER_ID, update())
        delete(Paths.Users.USER_ID, delete())
    }

    private fun all() = Route { _, _ ->
        mapper.writeValueAsString(userRepository.allUsers())

    }

    private fun userById() = Route { request, _ ->
        val id: Int = request.params("id").toInt()
        mapper.writeValueAsString(userRepository.userById(id))
    }

    private fun activeUsers() = Route { _, _ ->
        mapper.writeValueAsString(userRepository.activeUsers())
    }

    private fun create() = Route { request, response ->
        val user: User = mapper.readValue(request.body())
        response.status(HttpStatus.CREATED_201)
        mapper.writeValueAsString(userRepository.createNewUser(user))
    }

    private fun update() = Route { request, _ ->
        val id: Int = request.params("id").toInt()
        val user: User = mapper.readValue(request.body())
        val isUserUpdated = userRepository.updateUser(id, user)
        val message = if (isUserUpdated) "User updated successfully" else "Error updating user"
        mapper.writeValueAsString(message)
    }

    private fun delete() = Route { request, _ ->
        val id: Int = request.params("id").toInt()
        val isUserDeleted = userRepository.deleteUser(id)
        val message = if (isUserDeleted) "User deleted successfully" else "Error deleting user"
        mapper.writeValueAsString(message)
    }
}
