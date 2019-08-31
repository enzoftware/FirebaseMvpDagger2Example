package com.upc.monitoringwalkers.ui.login.view

interface LoginView {
    fun onLoginSuccess()
    fun onLoginError()
    fun showEmailError()
    fun showPasswordError()
}