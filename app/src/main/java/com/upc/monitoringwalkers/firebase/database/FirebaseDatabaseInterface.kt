package com.upc.monitoringwalkers.firebase.database

import com.upc.monitoringwalkers.model.PatientEntity

interface FirebaseDatabaseInterface {
    fun createPatient(patientEntity: PatientEntity)
    fun getPatientProfile(id: String, onResult: (PatientEntity) -> Unit)
}