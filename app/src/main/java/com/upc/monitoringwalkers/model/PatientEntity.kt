package com.upc.monitoringwalkers.model

import android.os.Bundle

data class PatientEntity(
    var id: String = "",
    var name: String = "",
    var lastName: String = "",
    var email: String = "",
    val type: UserType = UserType.PATIENT,
    var age: Int = 0,
    var treatment: String = "",
    var weight: Int = 0,
    var affectation: Affectation = Affectation.LOW,
    var doctorId: String = ""
) {
    companion object {
        fun from(bundle: Bundle): PatientEntity {
            return PatientEntity(
            )
        }
    }

    fun toBundle(): Bundle {
        val bundle = Bundle()
        with(bundle) {
            putString("id", id)
        }
        return bundle
    }
}

fun PatientEntity.mapToPatient() =
    PatientEntity(id, name, lastName, email, type, age, treatment, weight, affectation, doctorId)
fun PatientEntity.isValid() = name.isNotBlank()
        && email.isNotBlank()
        && type.toString().isNotBlank()