package com.upc.monitoringwalkers.model

class Doctor(
    override val id: String,
    override var name: String,
    override var lastName: String,
    override var username: String,
    override var password: String,
    override val type: UserType
) : User()