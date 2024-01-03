package com.vsp.repository

import com.vsp.model.User
import com.vsp.repository.UserRepository
import com.google.firebase.cloud.FirestoreClient
import org.springframework.stereotype.Repository

@Repository
class FirebaseUserRepository : UserRepository {

    private val firestore = FirestoreClient.getFirestore()

    override fun saveUser(user: User): User {
        val document = firestore.collection("users").document(user.id)
        document.set(user).get()
        return user
    }

    override fun getUserById(id: String): User? {
        val document = firestore.collection("users").document(id).get().get()
        return if (document.exists()) {
            document.toObject(User::class.java)
        } else {
            null
        }
    }


    override fun deleteUser(id: String): Boolean {
        val document = firestore.collection("users").document(id)
        document.delete().get()
        return !document.get().get().exists()
    }

}