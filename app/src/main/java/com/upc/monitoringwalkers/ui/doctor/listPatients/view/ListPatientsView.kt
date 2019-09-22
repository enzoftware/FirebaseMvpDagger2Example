package com.upc.monitoringwalkers.ui.doctor.listPatients.view

import com.upc.monitoringwalkers.model.PatientEntity

interface ListPatientsView {

    fun showNoDataDescription()

    fun hideNoDataDescription()

    fun addPatient(patientEntity: PatientEntity)

    fun deletePatient(patientEntity: PatientEntity)

    fun logoutSuccess()
}