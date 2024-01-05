package com.vsp.com.vsp.rowmap

import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet
import com.vsp.model.User
import java.sql.SQLException

class UserRowMapper : RowMapper<User> {
    @Throws(SQLException::class)
    override fun mapRow(rs: ResultSet, rowNum: Int): User {
        return User(
            id = rs.getString("id"),
            email = rs.getString("email"),
            nickname = rs.getString("nickname"),
            age = rs.getInt("age"),
            gender = rs.getString("gender"),
            role = rs.getString("role")
            // Map other fields as necessary
        )
    }
}
