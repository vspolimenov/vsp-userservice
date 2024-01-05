package com.vsp.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.vsp.com.vsp.model.UserLoginDto
import com.vsp.model.User
import com.vsp.service.UserService
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService) {


    private val objectMapper = ObjectMapper()
    @GetMapping("/health")
    fun handleGetRequest(): String {
        data class HealthStatus(val application: String, val status: String)
        return   objectMapper.writeValueAsString(HealthStatus(application = "vsp-userservices", status = "OK"));
    }

    @PostMapping("/register")
    fun registerUser(@RequestBody user: User): ResponseEntity<User> {
        val registeredUser = userService.registerUser(user)
        return ResponseEntity.ok(registeredUser)
    }

    @PostMapping("/login")
    fun loginUser(@RequestBody userDetails: UserLoginDto, request: HttpServletRequest): ResponseEntity<User?> {
        val token = request.getHeader("Authorization")?.substring("Bearer ".length)
        token?.let {
            val user = userService.loginUser(userDetails, it)
            return ResponseEntity.ok(user)
        }
        return ResponseEntity.badRequest().build() // Or handle as needed
    }
    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: String): ResponseEntity<Boolean> {
        val isDeleted = userService.deleteUser(id)
        return ResponseEntity.ok(isDeleted)
    }
}
