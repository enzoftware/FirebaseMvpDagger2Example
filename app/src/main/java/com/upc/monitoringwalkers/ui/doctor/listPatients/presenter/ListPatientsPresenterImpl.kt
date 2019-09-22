package com.upc.monitoringwalkers.ui.doctor.listPatients.presenter

import com.upc.monitoringwalkers.firebase.authentication.FirebaseAuthenticationInterface
import com.upc.monitoringwalkers.firebase.database.FirebaseDatabaseInterface
import com.upc.monitoringwalkers.model.PatientEntity
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


    override fun viewReady(doctorId: String) {
        listAllPatientByDoctor(doctorId)
    }

    override fun listAllPatientByDoctor(doctorId: String) {
        databaseInterface.listenToPatientByDoctor(doctorId) {
            view.addPatient(it)
        }
    }

    override fun logout() {
        authentication.logout {
            view.logoutSuccess()
        }
    }

    override fun onDeleteButtonClicked(patientEntity: PatientEntity) {
        databaseInterface.deleteUser(patientEntity.id) {
            view.deletePatient(patientEntity)
        }
    }
}