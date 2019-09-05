package com.upc.monitoringwalkers.ui.doctor.listPatients.presenter

import com.upc.monitoringwalkers.firebase.authentication.FirebaseAuthenticationInterface
import com.upc.monitoringwalkers.firebase.database.FirebaseDatabaseInterface
import com.upc.monitoringwalkers.ui.doctor.listPatients.view.ListPatientsView
import javax.inject.Inject

class ListPatientsPresenterImpl @Inject constructor(
    private val authentication: FirebaseAuthenticationInterface,
    private val databaseInterface: FirebaseDatabaseInterface
) : ListPatientsPresenter {

    private lateinit var view: ListPatientsView

    override fun setView(view: ListPatientsView) {
        this.view = view
    }


}