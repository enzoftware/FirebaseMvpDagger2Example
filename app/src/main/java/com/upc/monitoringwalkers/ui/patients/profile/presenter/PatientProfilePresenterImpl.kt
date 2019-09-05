package com.upc.monitoringwalkers.ui.patients.profile.presenter

import com.upc.monitoringwalkers.firebase.authentication.FirebaseAuthenticationInterface
import com.upc.monitoringwalkers.firebase.database.FirebaseDatabaseInterface
import com.upc.monitoringwalkers.ui.patients.profile.view.PatientProfileView
import javax.inject.Inject

class PatientProfilePresenterImpl @Inject constructor(
    private val authentication: FirebaseAuthenticationInterface,
    private val databaseInterface: FirebaseDatabaseInterface
) : PatientProfilePresenter {

    private lateinit var view: PatientProfileView

    override fun setView(view: PatientProfileView) {
        this.view = view
    }
}