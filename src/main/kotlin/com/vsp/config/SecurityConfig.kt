package com.vsp.config

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
open class SecurityConfig : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity) {
        http
            .csrf().disable() // Disable CSRF protection as JWT is used
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Use stateless sessions
            .and()
            .authorizeRequests()
            .antMatchers("/users/login", "/users/register").permitAll() // Allow everyone to access login and register endpoints
            .anyRequest().authenticated() // All other requests should be authenticated
        // You might want to add a filter here to verify JWT token
    }
}