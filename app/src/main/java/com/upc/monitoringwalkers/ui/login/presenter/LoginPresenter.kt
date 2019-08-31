package com.upc.monitoringwalkers.ui.login.presenter

import com.upc.monitoringwalkers.ui.base.BasePresenter
import com.upc.monitoringwalkers.ui.login.view.LoginView

interface LoginPresenter : BasePresenter<LoginView> {
    fun onLoginClicked()
    fun onEmailChanged(email: String)
    fun onPasswordChanged(password: String)
}