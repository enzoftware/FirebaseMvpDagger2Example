package com.upc.monitoringwalkers.ui.admin.listDoctors

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.upc.monitoringwalkers.R
import com.upc.monitoringwalkers.listDoctorsPresenter
import com.upc.monitoringwalkers.model.DoctorEntity
import com.upc.monitoringwalkers.ui.admin.addDoctor.AddDoctorActivity
import com.upc.monitoringwalkers.ui.admin.listDoctors.view.ListDoctorsView
import com.upc.monitoringwalkers.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_list_doctors.*
import kotlinx.android.synthetic.main.content_list_doctors.*

class ListDoctorsActivity : BaseActivity(), ListDoctorsView {

    private val presenter by lazy { listDoctorsPresenter() }
    private val adapter by lazy { DoctorAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_doctors)
        setSupportActionBar(toolbar)
        presenter.setView(this)
        presenter.viewReady()
        initUi()
        fab.setOnClickListener {
            startActivity(Intent(this, AddDoctorActivity::class.java))
        }
    }

    private fun initUi() {
        doctors_list_recycler_view.layoutManager = LinearLayoutManager(this)
        doctors_list_recycler_view.setHasFixedSize(true)
        doctors_list_recycler_view.adapter = adapter
    }

    override fun showNoDataDescription() {
        noItems.visibility = View.VISIBLE
    }

    override fun hideNoDataDescription() {
        noItems.visibility = View.GONE
    }

    override fun addDoctor(doctorEntity: DoctorEntity) {
        adapter.addDoctor(doctorEntity)
        noItems.visibility = if (adapter.itemCount != 0) View.INVISIBLE else View.VISIBLE
    }

}
