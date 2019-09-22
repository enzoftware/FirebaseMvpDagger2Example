package com.upc.monitoringwalkers.ui.admin.listDoctors.presenter

import com.upc.monitoringwalkers.firebase.authentication.FirebaseAuthenticationInterface
import com.upc.monitoringwalkers.firebase.database.FirebaseDatabaseInterface
import com.upc.monitoringwalkers.model.DoctorEntity
import com.upc.monitoringwalkers.ui.admin.listDoctors.view.ListDoctorsView
import javax.inject.Inject

class ListDoctorsPresenterImpl @Inject constructor(
    private val databaseInterface: FirebaseDatabaseInterface,
    private val authenticationInterface: FirebaseAuthenticationInterface
) : ListDoctorsPresenter {

    private lateinit var view: ListDoctorsView

    override fun setView(view: ListDoctorsView) {
        this.view = view
    }

    override fun viewReady() {
        getAllDoctors()
    }

    override fun getAllDoctors() {
        databaseInterface.listenToDoctors {
            view.addDoctor(it)
        }
    }

    override fun logout() {
        authenticationInterface.logout {
            view.onLogoutSuccess()
        }
    }

    override fun onDeleteButtonClicked(doctorEntity: DoctorEntity) {
        databaseInterface.deleteUser(doctorEntity.id) {
            view.deleteDoctor(doctorEntity)
        }
    }
}