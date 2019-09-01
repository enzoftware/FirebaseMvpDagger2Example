package com.upc.monitoringwalkers.model

data class PatientEntity(
    val id: String,
    var name: String,
    var lastName: String,
    var email: String,
    val type: UserType,
    var age: Int,
    var treatment: String
)