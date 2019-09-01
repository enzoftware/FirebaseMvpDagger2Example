package com.upc.monitoringwalkers.ui.admin.addDoctor.presenter

import com.upc.monitoringwalkers.common.arePasswordsSame
import com.upc.monitoringwalkers.common.isEmailValid
import com.upc.monitoringwalkers.common.isPasswordValid
import com.upc.monitoringwalkers.firebase.authentication.FirebaseAuthenticationInterface
import com.upc.monitoringwalkers.firebase.database.FirebaseDatabaseInterface
import com.upc.monitoringwalkers.model.DoctorEntity
import com.upc.monitoringwalkers.model.RegisterDoctorModel
import com.upc.monitoringwalkers.ui.admin.addDoctor.view.AddDoctorView
import javax.inject.Inject

class AddDoctorPresenterImpl @Inject constructor(
    private val databaseInterface: FirebaseDatabaseInterface,
    private val authenticationInterface: FirebaseAuthenticationInterface
) : AddDoctorPresenter {

    private lateinit var view: AddDoctorView

    private val doctorModel = RegisterDoctorModel()

    override fun setView(view: AddDoctorView) {
        this.view = view
    }

    override fun onNameChanged(name: String) {
        doctorModel.name = name
    }

    override fun onLastNameChanged(lastName: String) {
        doctorModel.lastName = lastName
    }

    override fun onEmailChanged(email: String) {
        doctorModel.email = email
        if (!isEmailValid(email)) {
            view.showEmailError()
        }
    }

    override fun onPasswordChanged(password: String) {
        doctorModel.password = password
        if (!isPasswordValid(password)) {
            view.showPasswordError()
        }
    }

    override fun onRepeatPasswordChanged(repeatPassword: String) {
        doctorModel.repeatPassword = repeatPassword
        if (!arePasswordsSame(doctorModel.password, repeatPassword)) {
            view.showPasswordMatchingError()
        }
    }

    override fun onRegisterClicked() {
        if (doctorModel.isValid()) {
            authenticationInterface.register(
                doctorModel.email,
                doctorModel.password,
                doctorModel.name
            ) { isSuccessful ->
                onRegisterResult(isSuccessful, doctorModel)
            }
        } else {
            print("Fallo")
        }

    }


    private fun onRegisterResult(isSuccessful: Boolean, doctor: RegisterDoctorModel) {
        if (isSuccessful) {
            createPatient(doctor)
            view.onRegisterSuccess()
        } else {
            view.showSignUpError()
        }
    }

    private fun createPatient(doctor: RegisterDoctorModel) {
        val id = authenticationInterface.getUserId()
        val doctorEntity = DoctorEntity(
            id,
            doctor.name,
            doctor.lastName,
            doctor.email,
            doctor.type
        )
        databaseInterface.createDoctor(doctorEntity)
    }
}