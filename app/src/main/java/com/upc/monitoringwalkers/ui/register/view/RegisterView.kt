package com.upc.monitoringwalkers.ui.register.view

interface RegisterView {

    fun onRegisterSuccess()

    fun showSignUpError()

    fun showEmailError()

    fun showPasswordError()

    fun showPasswordMatchingError()
}