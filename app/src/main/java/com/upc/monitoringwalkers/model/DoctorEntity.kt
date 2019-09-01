package com.upc.monitoringwalkers.model

data class DoctorEntity(
    val id: String,
    var name: String,
    var lastName: String,
    var password: String,
    var email: String,
    val type: UserType,
    var username: String
)