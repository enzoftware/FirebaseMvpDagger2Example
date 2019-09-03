package com.upc.monitoringwalkers.ui.login.view

import com.upc.monitoringwalkers.model.MWCurrentUser

interface LoginView {
    fun onLoginSuccess(currentUser: MWCurrentUser)
    fun onLoginError()
    fun showEmailError()
    fun showPasswordError()

    fun onCurrentUserIsDoctor()

    fun onCurrentUserIsPatient()

    fun onCurrentUserIsAdmin()

}