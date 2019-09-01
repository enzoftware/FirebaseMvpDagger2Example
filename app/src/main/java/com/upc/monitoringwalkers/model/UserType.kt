package com.upc.monitoringwalkers.model

enum class UserType {
    DOCTOR, // can add patients
    PATIENT, // only can view info
    ADMIN // can add doctors
}
