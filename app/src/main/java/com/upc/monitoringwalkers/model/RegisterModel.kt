package com.upc.monitoringwalkers.model

import com.upc.monitoringwalkers.common.arePasswordsSame
import com.upc.monitoringwalkers.common.isEmailValid

data class RegisterPatientModel(
    var name: String = "",
    var lastName: String = "",
    var email: String = "",
    val type: UserType = UserType.PATIENT,
    var password: String = "",
    var repeatPassword: String = "",
    var age: Int = 0,
    var treatment: String = ""
) {
    fun isValid(): Boolean = isEmailValid(email) && arePasswordsSame(password, repeatPassword)
}