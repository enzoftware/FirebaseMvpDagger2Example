package com.upc.monitoringwalkers.ui.admin.listDoctors.presenter

import com.upc.monitoringwalkers.ui.admin.listDoctors.view.ListDoctorsView
import com.upc.monitoringwalkers.ui.base.BasePresenter

interface ListDoctorsPresenter : BasePresenter<ListDoctorsView> {
    fun viewReady()

    fun getAllDoctors()
}