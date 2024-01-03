package com.vsp.controller

import com.vsp.model.User
import com.vsp.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService) {

    @GetMapping("/health")
    fun handleGetRequest(): String {
        return "Response for GET request"
    }

    @PostMapping("/register")
    fun registerUser(@RequestBody user: User): ResponseEntity<User> {
        val registeredUser = userService.registerUser(user)
        return ResponseEntity.ok(registeredUser)
    }

    @PostMapping("/login")
    fun loginUser(@RequestBody token: String): ResponseEntity<User?> {
        val user = userService.loginUser(token)
        return ResponseEntity.ok(user)
    }
    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: String): ResponseEntity<Boolean> {
        val isDeleted = userService.deleteUser(id)
        return ResponseEntity.ok(isDeleted)
    }
}
