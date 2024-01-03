package com.vsp.service

import com.vsp.model.User

interface UserService {
    fun registerUser(user: User): User
    fun loginUser(token: String): User?
    fun deleteUser(id: String): Boolean
}