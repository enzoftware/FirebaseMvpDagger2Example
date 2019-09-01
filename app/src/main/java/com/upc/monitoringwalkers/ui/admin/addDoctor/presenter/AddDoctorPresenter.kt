package com.upc.monitoringwalkers.ui.admin.addDoctor.presenter

import com.upc.monitoringwalkers.ui.admin.addDoctor.view.AddDoctorView
import com.upc.monitoringwalkers.ui.base.BasePresenter

interface AddDoctorPresenter : BasePresenter<AddDoctorView> {

    fun onNameChanged(name: String)

    fun onLastNameChanged(lastName: String)

    fun onEmailChanged(email: String)

    fun onPasswordChanged(password: String)

    fun onRepeatPasswordChanged(repeatPassword: String)

    fun onRegisterClicked()
}