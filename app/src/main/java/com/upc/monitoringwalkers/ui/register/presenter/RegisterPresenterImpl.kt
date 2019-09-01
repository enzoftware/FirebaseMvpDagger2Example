package com.upc.monitoringwalkers.ui.register.presenter

import com.upc.monitoringwalkers.common.arePasswordsSame
import com.upc.monitoringwalkers.common.isEmailValid
import com.upc.monitoringwalkers.common.isPasswordValid
import com.upc.monitoringwalkers.firebase.authentication.FirebaseAuthenticationInterface
import com.upc.monitoringwalkers.firebase.database.FirebaseDatabaseInterface
import com.upc.monitoringwalkers.model.Patient
import com.upc.monitoringwalkers.model.RegisterModel
import com.upc.monitoringwalkers.model.UserType
import com.upc.monitoringwalkers.ui.register.view.RegisterView
import javax.inject.Inject

class RegisterPresenterImpl @Inject constructor(
    private val databaseInterface: FirebaseDatabaseInterface,
    private val authenticationInterface: FirebaseAuthenticationInterface
) : RegisterPresenter {

    private lateinit var view: RegisterView

    private val userModel = RegisterModel()

    override fun setView(view: RegisterView) {
        this.view = view
    }


    override fun onEmailChanged(email: String) {
        userModel.email = email
        if (!isEmailValid(email)) {
            view.showEmailError()
        }
    }

    override fun onPasswordChanged(password: String) {
        userModel.password = password
        if (!isPasswordValid(password)) {
            view.showPasswordError()
        }
    }

    override fun onRepeatPasswordChanged(repeatPassword: String) {
        userModel.repeatPassword = repeatPassword
        if (!arePasswordsSame(userModel.password, repeatPassword)) {
            view.showPasswordMatchingError()
        }
    }

    override fun onRegisterClicked() {
        if (userModel.isValid()) {

        }
    }

    private fun onRegisterResult(isSuccessful: Boolean) {
        if (!isSuccessful) {

            view.onRegisterSuccess()
        } else {
            view.showSignUpError()
        }
    }

    private fun createPatient(
        username: String,
        email: String,
        name: String,
        lastName: String,
        age: Int,
        treatment: String,
        type: UserType
    ) {
        val id = authenticationInterface.getUserId()
        val patient = Patient(
            id,
            name,
            lastName,
            password = "",
            type = type,
            age = age,
            treatment = treatment,
            email = email,
            username = username

        )
        databaseInterface.createPatient(patient)
    }
}