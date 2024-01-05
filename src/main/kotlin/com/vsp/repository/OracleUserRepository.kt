package com.vsp.com.vsp.repository

import com.vsp.com.vsp.rowmap.UserRowMapper
import org.springframework.stereotype.Repository
import com.vsp.model.User
import com.vsp.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate

@Repository
class OracleUserRepository(@Autowired private val jdbcTemplate: JdbcTemplate) : UserRepository {

    override fun saveUser(user: User): User {
        val sql = "INSERT INTO users (id, email, nickname, age, gender, role) VALUES (?, ?, ?, ?, ?, ?)"
        jdbcTemplate.update(sql, user.id, user.email, user.nickname, user.age, user.gender, user.role)
        return user
    }

    override fun getUserById(id: String): User? {
        val sql = "SELECT * FROM users WHERE id = ?"
        return jdbcTemplate.queryForObject(sql, arrayOf(id), UserRowMapper())
    }

    override fun deleteUser(id: String): Boolean {
        val sql = "DELETE FROM users WHERE id = ?"
        return jdbcTemplate.update(sql, id) > 0
    }

    // Additional methods and inner classes as necessary
}
