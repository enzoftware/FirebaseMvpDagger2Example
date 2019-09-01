package com.upc.monitoringwalkers.model

data class Doctor(
    override val id: String,
    override var name: String,
    override var lastName: String,
    override var password: String,
    override val type: UserType,
    var username: String, override var email: String
) : User()