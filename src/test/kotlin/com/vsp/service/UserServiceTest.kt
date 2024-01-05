package com.vsp.service

import com.vsp.model.User
import com.vsp.repository.UserRepository
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.mockito.Mockito

class UserServiceTest {

    private val userRepository = Mockito.mock(UserRepository::class.java)
    private val userService = UserServiceImpl(userRepository)

//    @Test
//    fun testRegisterUser() {
//        val user = User("id123", "testUser", "password")
//        Mockito.`when`(userRepository.saveUser(user)).thenReturn(user)
//
//        val result = userService.registerUser(user)
//        assertNotNull(result)
//        assertEquals(user.username, result.username)
//    }
}