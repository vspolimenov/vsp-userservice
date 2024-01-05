package com.vsp.service

import com.vsp.model.User
import com.vsp.repository.UserRepository
import com.vsp.service.UserService
import org.springframework.stereotype.Service
import com.google.firebase.auth.FirebaseAuth
import com.vsp.com.vsp.model.UserLoginDto
import org.springframework.beans.factory.annotation.Qualifier

@Service
class UserServiceImpl(@Qualifier("oracleUserRepository") private val userRepository: UserRepository) : UserService {

    override fun registerUser(user: User): User {
        // Implement registration logic
        return userRepository.saveUser(user)
    }

    override fun loginUser(userDetails: UserLoginDto, token: String): User? {
        return try {
            val decodedToken = FirebaseAuth.getInstance().verifyIdToken(token)
            val uid = decodedToken.uid

            // Use UID to perform further operations or retrieve additional user data
            userRepository.getUserById(uid) // Example method to retrieve user details
        } catch (e: Exception) {
            // Handle exceptions such as invalid or expired token
            null
        }
    }



    override fun deleteUser(id: String): Boolean {
        // Implement delete logic
        return userRepository.deleteUser(id)
    }
}
