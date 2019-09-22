package com.upc.monitoringwalkers.ui.doctor.listPatients.presenter

import com.upc.monitoringwalkers.model.PatientEntity
import com.upc.monitoringwalkers.ui.base.BasePresenter
import com.upc.monitoringwalkers.ui.doctor.listPatients.view.ListPatientsView

interface ListPatientsPresenter : BasePresenter<ListPatientsView> {

    fun viewReady(doctorId: String)

    fun listAllPatientByDoctor(doctorId: String)

    fun logout()

    fun onDeleteButtonClicked(patientEntity: PatientEntity)
}