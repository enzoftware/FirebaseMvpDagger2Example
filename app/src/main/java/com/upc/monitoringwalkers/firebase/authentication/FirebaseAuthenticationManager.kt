package com.upc.monitoringwalkers.firebase.authentication

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import javax.inject.Inject

class FirebaseAuthenticationManager @Inject constructor(private val authentication: FirebaseAuth) :
    FirebaseAuthenticationInterface {

    override fun login(email: String, password: String, onResult: (Boolean) -> Unit) {
        authentication.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            authentication.currentUser?.updateProfile(
                UserProfileChangeRequest.Builder().setDisplayName(email).build()
            )
            onResult(it.isComplete && it.isSuccessful)
        }
    }

    override fun getUserId(): String = authentication.currentUser?.uid ?: ""

    override fun getUsername(): String = authentication.currentUser?.displayName ?: ""


    override fun logout(onResult: () -> Unit) {
        authentication.signOut()
        onResult()
    }

    override fun register(
        email: String,
        password: String,
        username: String,
        onResult: (Boolean) -> Unit
    ) {
        authentication.createUserWithEmailAndPassword(email, password).addOnCompleteListener {

            if (it.isComplete && it.isSuccessful) {
                onResult(true)
            } else {
                onResult(false)
            }
        }
    }
}