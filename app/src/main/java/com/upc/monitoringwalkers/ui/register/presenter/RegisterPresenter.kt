package com.upc.monitoringwalkers.ui.register.presenter

interface RegisterPresenter {

    fun onUsernameChanged(username: String)

    fun onEmailChanged(email: String)

    fun onPasswordChanged(password: String)

    fun onRepeatPasswordChanged(repeatPassword: String)

    fun onRegisterClicked()

}