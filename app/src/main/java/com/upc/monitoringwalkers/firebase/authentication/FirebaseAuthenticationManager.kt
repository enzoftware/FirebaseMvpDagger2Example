package com.upc.monitoringwalkers.firebase.authentication

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class FirebaseAuthenticationManager @Inject constructor(private val authentication: FirebaseAuth) :
    FirebaseAuthenticationInterface {

    override fun login(email: String, password: String, onResult: (Boolean, String) -> Unit) {
        authentication.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            Log.i("userInfo", getUserId())
            onResult(it.isComplete && it.isSuccessful, getUserId())
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