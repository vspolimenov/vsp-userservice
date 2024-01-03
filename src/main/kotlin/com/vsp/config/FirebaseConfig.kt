package com.vsp.config
import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import java.io.FileInputStream
import javax.annotation.PostConstruct
import org.springframework.context.annotation.Configuration

@Configuration
open class FirebaseConfig {

    @PostConstruct
    fun initializeFirebase() {
        val serviceAccount = FileInputStream("google-service.json")

        val options = FirebaseOptions.builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .build()

        FirebaseApp.initializeApp(options)
    }
}
