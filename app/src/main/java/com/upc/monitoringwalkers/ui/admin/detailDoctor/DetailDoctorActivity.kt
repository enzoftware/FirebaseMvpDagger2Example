package com.upc.monitoringwalkers.ui.admin.detailDoctor

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.upc.monitoringwalkers.R
import com.upc.monitoringwalkers.detailDoctorPresenter
import com.upc.monitoringwalkers.model.DoctorEntity
import com.upc.monitoringwalkers.ui.admin.detailDoctor.view.DetailDoctorView
import com.upc.monitoringwalkers.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_detail_doctor.*

class DetailDoctorActivity : BaseActivity(), DetailDoctorView {

    private val presenter by lazy { detailDoctorPresenter() }
    private lateinit var doctorId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_doctor)
        presenter.setView(this)
        doctorId = intent.extras!!.getString("doctorId").toString()

        initUi()
    }

    private fun initUi() {
        presenter.fetchDoctorProfile(doctorId)
        supportActionBar!!.setTitle(R.string.detail_doctor)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onFetchDoctorProfileSuccess(doctorEntity: DoctorEntity) {
        detail_doctor_progress.visibility = View.GONE
        detail_doctor_profile.visibility = View.VISIBLE
        detail_doctor_full_name.text = "${doctorEntity.name} ${doctorEntity.lastName}"
        detail_doctor_email.text = doctorEntity.email
        Glide
            .with(this)
            .load("https://cdn3.iconfinder.com/data/icons/healthcare-medical-lilac-series-vol-1/256/DOCTOR-512.png") // TODO : custom photo
            .centerCrop()
            .placeholder(R.drawable.ic_person_outline_black_24dp)
            .into(detail_doctor_image)
    }

    override fun onFetchDoctorProfileFail(error: String) {
        detail_doctor_progress.visibility = View.GONE
        detail_doctor_error.apply {
            visibility = View.VISIBLE
            text = error
        }


    }
}
