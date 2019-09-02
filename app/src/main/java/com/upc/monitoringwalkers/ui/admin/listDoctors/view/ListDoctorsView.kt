package com.upc.monitoringwalkers.ui.admin.listDoctors.view

import com.upc.monitoringwalkers.model.DoctorEntity

interface ListDoctorsView {

    fun showNoDataDescription()

    fun hideNoDataDescription()

    fun addDoctor(doctorEntity: DoctorEntity)

}