package com.upc.monitoringwalkers.ui.patients.profile.presenter

import com.upc.monitoringwalkers.ui.patients.profile.view.PatientProfileView

class PatientProfilePresenterImpl : PatientProfilePresenter {

    private lateinit var view: PatientProfileView

    override fun setView(view: PatientProfileView) {
        this.view = view
    }
}