package com.upc.monitoringwalkers.model

enum class UserType {
    DOCTOR, // can add patients
    PATIENT, // only can view info
    ADMIN // can add doctors
}

abstract class User {
    abstract val id: String
    abstract var name: String
    abstract var lastName: String
    abstract var password: String
    abstract var email: String
    abstract val type: UserType
}