package com.upc.monitoringwalkers.ui.admin.listDoctors

import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.upc.monitoringwalkers.R
import com.upc.monitoringwalkers.listDoctorsPresenter
import com.upc.monitoringwalkers.model.DoctorEntity
import com.upc.monitoringwalkers.ui.admin.listDoctors.view.ListDoctorsView
import com.upc.monitoringwalkers.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_list_doctors.*
import kotlinx.android.synthetic.main.content_list_doctors.*

class ListDoctorsActivity : BaseActivity(), ListDoctorsView {

    private val presenter by lazy { listDoctorsPresenter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_doctors)
        setSupportActionBar(toolbar)
        presenter.setView(this)
        presenter.viewReady()
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun showNoDataDescription() {
        noItems.visibility = View.VISIBLE
    }

    override fun hideNoDataDescription() {
        noItems.visibility = View.GONE
    }

    override fun addDoctor(doctorEntity: DoctorEntity) {

//        noItems.visibility = if (adapter.itemCount != 0) View.INVISIBLE else View.VISIBLE
    }

}
