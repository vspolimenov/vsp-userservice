package com.vsp.model

data class User(
    val id: String,
    val email: String,
    val nickname: String,
    val age: Int,
    val gender: String,
    val role: String
    // ... other fields as necessary
)