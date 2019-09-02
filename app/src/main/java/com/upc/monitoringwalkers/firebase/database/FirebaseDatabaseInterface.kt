package com.upc.monitoringwalkers.firebase.database

import com.upc.monitoringwalkers.model.DoctorEntity
import com.upc.monitoringwalkers.model.PatientEntity

interface FirebaseDatabaseInterface {
    fun createPatient(patientEntity: PatientEntity)
    fun createDoctor(doctorEntity: DoctorEntity)
    fun getPatientProfile(id: String, onResult: (PatientEntity) -> Unit)
    fun getDoctorProfile(id: String, onResult: (DoctorEntity) -> Unit)
    fun getUserType(id: String, onResult: (String) -> Unit)
    fun getAllDoctors(onResult: (List<DoctorEntity>) -> Unit)
    fun getPatientsByDoctor(doctorId: String, onResult: (List<PatientEntity>) -> Unit)
    fun listenToDoctors(onResult: (DoctorEntity) -> Unit)
}