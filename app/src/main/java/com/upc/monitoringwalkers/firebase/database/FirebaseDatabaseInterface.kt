package com.upc.monitoringwalkers.firebase.database

import com.upc.monitoringwalkers.model.Patient

interface FirebaseDatabaseInterface {
    fun createPatient(patient: Patient)
    fun getPatientProfile(id: String, onResult: (Patient) -> Unit)
}