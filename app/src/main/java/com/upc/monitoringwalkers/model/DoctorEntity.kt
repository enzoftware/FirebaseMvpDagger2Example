package com.upc.monitoringwalkers.model

data class DoctorEntity(
    var id: String = "",
    var name: String = "",
    var lastName: String = "",
    var email: String = "",
    val type: UserType = UserType.DOCTOR
)

fun DoctorEntity.mapToDoctor() = DoctorEntity(id, name, lastName, email, type)
fun DoctorEntity.isValid() = name.isNotBlank()
        && email.isNotBlank()
        && type.toString().isNotBlank()