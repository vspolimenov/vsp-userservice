package com.vsp.repository

import com.vsp.model.User

interface UserRepository {
    fun saveUser(user: User): User
    fun getUserById(id: String): User?
    fun deleteUser(id: String): Boolean
    // Additional methods as required
}
