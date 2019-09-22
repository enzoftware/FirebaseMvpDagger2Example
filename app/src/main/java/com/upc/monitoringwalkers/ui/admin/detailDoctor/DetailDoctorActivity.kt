package com.upc.monitoringwalkers.ui.admin.detailDoctor

import android.os.Bundle
import com.upc.monitoringwalkers.R
import com.upc.monitoringwalkers.detailDoctorPresenter
import com.upc.monitoringwalkers.ui.admin.detailDoctor.view.DetailDoctorView
import com.upc.monitoringwalkers.ui.base.BaseActivity

class DetailDoctorActivity : BaseActivity(), DetailDoctorView {

    private val presenter by lazy { detailDoctorPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_doctor)
        presenter.setView(this)
    }
}
