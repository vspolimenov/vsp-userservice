package com.vsp.service

import com.vsp.com.vsp.model.UserLoginDto
import com.vsp.model.User

interface UserService {
    fun registerUser(user: User): User
    fun loginUser(userDetails: UserLoginDto, token: String): User?
    fun deleteUser(id: String): Boolean
}