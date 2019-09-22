package com.upc.monitoringwalkers.ui.admin.detailDoctor.presenter

import com.upc.monitoringwalkers.ui.admin.detailDoctor.view.DetailDoctorView

class DetailDoctorPresenterImpl : DetailDoctorPresenter {
    private lateinit var view: DetailDoctorView

    override fun setView(view: DetailDoctorView) {
        this.view = view
    }
}