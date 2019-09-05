package com.upc.monitoringwalkers.ui.doctor.listPatients.presenter

import com.upc.monitoringwalkers.ui.doctor.listPatients.view.ListPatientsView

class ListPatientsPresenterImpl : ListPatientsPresenter {

    private lateinit var view: ListPatientsView

    override fun setView(view: ListPatientsView) {
        this.view = view
    }


}