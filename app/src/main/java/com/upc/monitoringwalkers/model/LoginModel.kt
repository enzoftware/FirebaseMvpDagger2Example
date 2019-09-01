package com.upc.monitoringwalkers.model

import com.upc.monitoringwalkers.common.isEmailValid
import com.upc.monitoringwalkers.common.isPasswordValid

data class LoginModel(
    var email: String = "",
    var password: String = ""
) {
    fun isValid(): Boolean = isEmailValid(email) && isPasswordValid(password)
}