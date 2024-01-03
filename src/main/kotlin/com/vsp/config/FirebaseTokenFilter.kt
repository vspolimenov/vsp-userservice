package com.vsp.com.vsp.config

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseToken
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter

class FirebaseTokenFilter : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: jakarta.servlet.http.HttpServletRequest,
        response: jakarta.servlet.http.HttpServletResponse,
        filterChain: jakarta.servlet.FilterChain
    ) {

        val authToken = request.getHeader("Authorization")

        if (authToken != null && authToken.startsWith("Bearer ")) {
            try {
                val token = authToken.substring(7)
                val decodedToken: FirebaseToken = FirebaseAuth.getInstance().verifyIdToken(token)
                val auth = UsernamePasswordAuthenticationToken(decodedToken.uid, null, emptyList())
                SecurityContextHolder.getContext().authentication = auth
            } catch (e: Exception) {
                // Handle token validation errors
            }
        }

        filterChain.doFilter(request, response)
    }
}