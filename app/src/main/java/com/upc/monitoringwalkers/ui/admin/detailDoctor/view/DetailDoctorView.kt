package com.upc.monitoringwalkers.ui.admin.detailDoctor.view

import com.upc.monitoringwalkers.model.DoctorEntity

interface DetailDoctorView{
    fun onFetchDoctorProfileSuccess(doctorEntity: DoctorEntity)
    fun onFetchDoctorProfileFail(error: String)

}