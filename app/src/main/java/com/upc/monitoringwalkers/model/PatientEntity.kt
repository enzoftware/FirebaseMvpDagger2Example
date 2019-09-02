package com.upc.monitoringwalkers.model

data class PatientEntity(
    var id: String = "",
    var name: String = "",
    var lastName: String = "",
    var email: String = "",
    val type: UserType = UserType.PATIENT,
    var age: Int = 0,
    var treatment: String = "",
    var doctorId: String = ""
)