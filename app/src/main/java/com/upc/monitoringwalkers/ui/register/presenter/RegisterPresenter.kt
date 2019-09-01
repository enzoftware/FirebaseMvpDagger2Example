package com.upc.monitoringwalkers.ui.register.presenter

import com.upc.monitoringwalkers.ui.base.BasePresenter
import com.upc.monitoringwalkers.ui.register.view.RegisterView

interface RegisterPresenter : BasePresenter<RegisterView> {

    fun onEmailChanged(email: String)

    fun onPasswordChanged(password: String)

    fun onRepeatPasswordChanged(repeatPassword: String)

    fun onRegisterClicked()

}