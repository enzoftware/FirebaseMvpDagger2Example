package com.upc.monitoringwalkers.firebase.authentication

interface FirebaseAuthenticationInterface {
    fun login(email: String, password: String, onResult: (Boolean, String) -> Unit)
    fun getUserId(): String
    fun getUsername(): String
    fun logout(onResult: () -> Unit)
    fun register(
        email: String,
        password: String,
        username: String,
        onResult: (Boolean) -> Unit
    ) // todo : add profile photo
}