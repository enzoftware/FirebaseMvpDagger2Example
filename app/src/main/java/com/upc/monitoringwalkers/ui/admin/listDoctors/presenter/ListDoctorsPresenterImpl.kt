package com.upc.monitoringwalkers.ui.admin.listDoctors.presenter

import com.upc.monitoringwalkers.firebase.database.FirebaseDatabaseInterface
import com.upc.monitoringwalkers.ui.admin.listDoctors.view.ListDoctorsView
import javax.inject.Inject

class ListDoctorsPresenterImpl @Inject constructor(
    private val databaseInterface: FirebaseDatabaseInterface
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
}