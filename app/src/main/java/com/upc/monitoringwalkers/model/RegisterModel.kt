package com.upc.monitoringwalkers.model

import com.upc.monitoringwalkers.common.arePasswordsSame
import com.upc.monitoringwalkers.common.isEmailValid

data class RegisterModel(
    override val id: String = "",
    override var name: String = "",
    override var lastName: String = "",
    override var email: String = "",
    override val type: UserType = UserType.PATIENT,
    var repeatPassword: String = "",
    override var password: String = ""
) : User() {
    fun isValid(): Boolean = isEmailValid(email) && arePasswordsSame(password, repeatPassword)
}