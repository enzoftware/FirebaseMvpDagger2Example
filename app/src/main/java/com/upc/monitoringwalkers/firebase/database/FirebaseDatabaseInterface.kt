package com.upc.monitoringwalkers.firebase.database

import com.upc.monitoringwalkers.model.DoctorEntity
import com.upc.monitoringwalkers.model.PatientEntity

interface FirebaseDatabaseInterface {

    /**
     * Create a Patient instance to save into database.
     *
     * @param patientEntity Patient instance to add into the FirebaseDatabase
     */
    fun createPatient(patientEntity: PatientEntity)

    /**
     * Create a Doctor instance to save into database.
     *
     * @param doctorEntity Doctor instance to add into the FirebaseDatabase
     */
    fun createDoctor(doctorEntity: DoctorEntity)

    /**
     * Get all the patient data from the database and parse into an PatientEntity object.
     *
     * @param id Patient identifier in string
     * @param onResult Callback that is call when the method is finished
     */
    fun getPatientProfile(id: String, onResult: (PatientEntity) -> Unit)

    /**
     * Get all the doctor data from the database and parse into an DoctorEntity object.
     *
     * @param id Doctor identifier in string
     * @param onResult Callback that is call when the method is finished
     */
    fun getDoctorProfile(id: String, onResult: (DoctorEntity) -> Unit)

    /**
     * Get the user from FirebaseDatabase type given the identifier
     *
     * @param id User unique identifier to search it from the database
     * @param onResult Callback that is call when the method is finished with the user type as string
     */
    fun getUserType(id: String, onResult: (String) -> Unit)

    /**
     * Get all the USERS where the TYPE is DOCTOR.
     *
     * @param onResult Callback that is call when the result is given from the FirebaseDatabase
     */
    fun getAllDoctors(onResult: (List<DoctorEntity>) -> Unit)

    /**
     * Get the list of patients given the doctor identifier.
     *
     * @param doctorId Doctor unique identifier
     * @param onResult Callback that is call when the result is given as a list of PatientEntity
     */
    fun getPatientsByDoctor(doctorId: String, onResult: (List<PatientEntity>) -> Unit)


    /**
     * This method listen all the occurrences to the child of USERS that type is DOCTOR.
     *
     * @param onResult callback that refresh the UI with the database status
     */
    fun listenToDoctors(onResult: (DoctorEntity) -> Unit)


    fun listenToPatientByDoctor(doctorId: String, onResult: (PatientEntity) -> Unit)
}