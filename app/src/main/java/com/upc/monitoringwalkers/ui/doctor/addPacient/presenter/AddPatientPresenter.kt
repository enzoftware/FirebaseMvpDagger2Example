package com.upc.monitoringwalkers.ui.doctor.addPacient.presenter

import com.upc.monitoringwalkers.ui.base.BasePresenter
import com.upc.monitoringwalkers.ui.doctor.addPacient.view.AddPatientView

interface AddPatientPresenter : BasePresenter<AddPatientView> {

    fun onNameChanged(name: String)

    fun onLastNameChanged(lastName: String)

    fun onTreatmentChanged(treatment: String)

    fun onAgeChanged(age: String)

    fun onEmailChanged(email: String)

    fun onPasswordChanged(password: String)

    fun onRepeatPasswordChanged(repeatPassword: String)

    fun onRegisterClicked()

}