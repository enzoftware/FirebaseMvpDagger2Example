package com.upc.monitoringwalkers.ui.admin.detailDoctor.presenter

import com.upc.monitoringwalkers.firebase.database.FirebaseDatabaseInterface
import com.upc.monitoringwalkers.model.isValid
import com.upc.monitoringwalkers.ui.admin.detailDoctor.view.DetailDoctorView
import javax.inject.Inject

class DetailDoctorPresenterImpl @Inject constructor(
    private val databaseInterface: FirebaseDatabaseInterface
) : DetailDoctorPresenter {

    private lateinit var view: DetailDoctorView

    override fun setView(view: DetailDoctorView) {
        this.view = view
    }

    override fun fetchDoctorProfile(doctorId: String) {
        databaseInterface.getDoctorProfile(doctorId){
            if(it.isValid()){
                view.onFetchDoctorProfileSuccess(it)
            } else {
                view.onFetchDoctorProfileFail("No existe este doctor!")
            }
        }
    }

}