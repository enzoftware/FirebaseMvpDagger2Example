package com.upc.monitoringwalkers.model

class Patient(
    override val id: String,
    override var name: String,
    override var lastName: String,
    override var username: String,
    override var password: String,
    override val type: UserType = UserType.PATIENT,
    var age: Int,
    var treatment: String
) : User()