package com.upc.monitoringwalkers.ui.doctor.listPatients

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.upc.monitoringwalkers.R
import com.upc.monitoringwalkers.listPatientsPresenter
import com.upc.monitoringwalkers.model.MWCurrentUser
import com.upc.monitoringwalkers.model.PatientEntity
import com.upc.monitoringwalkers.model.getCurrentUserPreferenceObjectJson
import com.upc.monitoringwalkers.model.setCurrentUserPreferenceObject
import com.upc.monitoringwalkers.ui.base.BaseActivity
import com.upc.monitoringwalkers.ui.doctor.addPacient.AddPatientActivity
import com.upc.monitoringwalkers.ui.doctor.listPatients.view.ListPatientsView
import com.upc.monitoringwalkers.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_list_patients.*
import kotlinx.android.synthetic.main.content_list_patients.*

class ListPatientsActivity : BaseActivity(), ListPatientsView {

    private val presenter by lazy { listPatientsPresenter() }
    private val adapter by lazy { PatientAdapter(presenter::onDeleteButtonClicked) }
    private lateinit var currentUser: MWCurrentUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_patients)
        setSupportActionBar(toolbar)
        presenter.setView(this)
        initUi()
    }

    private fun initUi() {
        currentUser = getCurrentUserPreferenceObjectJson(this)
        patient_list_recycler_view.layoutManager = LinearLayoutManager(this)
        patient_list_recycler_view.setHasFixedSize(true)
        patient_list_recycler_view.adapter = adapter
        presenter.viewReady(currentUser.id)
        fab.setOnClickListener { view ->
            startActivity(Intent(this, AddPatientActivity::class.java))
        }
        list_patient_logout_btn.setOnClickListener {
            presenter.logout()
        }
    }

    override fun showNoDataDescription() {
        patientNoItems.visibility = View.VISIBLE
    }

    override fun hideNoDataDescription() {
        patientNoItems.visibility = View.GONE
    }

    override fun addPatient(patientEntity: PatientEntity) {
        adapter.addPatient(patientEntity)
        patientNoItems.visibility = if (adapter.itemCount != 0) View.INVISIBLE else View.VISIBLE
    }

    override fun deletePatient(patientEntity: PatientEntity) {
        adapter.removePatient(patientEntity)
    }

    override fun logoutSuccess() {
        setCurrentUserPreferenceObject(this, MWCurrentUser())
        finish()
        startActivity(Intent(this, LoginActivity::class.java))
    }

}
