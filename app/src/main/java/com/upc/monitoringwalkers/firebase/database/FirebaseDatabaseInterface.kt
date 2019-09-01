package com.upc.monitoringwalkers.firebase.database

import com.upc.monitoringwalkers.model.DoctorEntity
import com.upc.monitoringwalkers.model.PatientEntity

interface FirebaseDatabaseInterface {
    fun createPatient(patientEntity: PatientEntity)
    fun getPatientProfile(id: String, onResult: (PatientEntity) -> Unit)
    fun getDoctorProfile(id: String, onResult: (DoctorEntity) -> Unit)
    fun getUserType(id: String, onResult: (String) -> Unit)
//    fun getAdminProfile(id: String, onResult: (DoctorEntity) -> Unit)
}