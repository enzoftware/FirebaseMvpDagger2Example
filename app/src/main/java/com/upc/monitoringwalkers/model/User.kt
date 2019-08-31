package com.upc.monitoringwalkers.model

enum class UserType {
    DOCTOR,
    PATIENT
}

abstract class User {
    abstract val id: String
    abstract var name: String
    abstract var lastName: String
    abstract var username: String
    abstract var password: String
    abstract val type: UserType
}