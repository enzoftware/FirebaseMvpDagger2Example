package com.upc.monitoringwalkers.ui.admin.addDoctor.view

interface AddDoctorView {

    fun onRegisterSuccess()

    fun showSignUpError()

    fun showEmailError()

    fun showPasswordError()

    fun showPasswordMatchingError()
}