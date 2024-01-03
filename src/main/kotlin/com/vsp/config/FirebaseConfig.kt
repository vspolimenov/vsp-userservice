package com.vsp.config

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import javax.annotation.PostConstruct

@Configuration
open class FirebaseConfig {

    @PostConstruct
    fun initializeFirebase() {
        val resource = ClassPathResource("google-service.json")
        val serviceAccount = resource.inputStream

        val options = FirebaseOptions.builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .build()

        FirebaseApp.initializeApp(options)
    }
}