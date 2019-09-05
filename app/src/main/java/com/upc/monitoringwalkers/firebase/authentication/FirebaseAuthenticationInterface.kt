package com.upc.monitoringwalkers.firebase.authentication

interface FirebaseAuthenticationInterface {

    /**
     * Send a login request to FirebaseAuthentication.
     *
     * @param email User input that correspond to an string with email format
     * @param password User input that corresponds to the password
     * @param onResult Expects the success and complete of the login request and decide where view callback is call
     */
    fun login(email: String, password: String, onResult: (Boolean, String) -> Unit)

    /**
     * Get the user unique identifier from FirebaseAuthentication
     *
     * @return Current user identifier from FirebaseAuthentication
     */
    fun getUserId(): String

    /**
     * Get the user display name from FirebaseAuthentication
     *
     * @return Current user display name from FirebaseAuthentication
     */
    fun getUsername(): String

    /**
     * Close the current session
     *
     * @param onResult Callback which is called when the logout is success
     */
    fun logout(onResult: () -> Unit)

    /**
     * Request a register to FirebaseAuthentication
     *
     * @param email User email
     * @param password User password
     * @param onResult Callback that expects the success and complete off the register request
     */
    fun register(
        email: String,
        password: String,
        onResult: (Boolean) -> Unit
    )
}