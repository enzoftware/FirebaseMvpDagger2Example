package com.upc.monitoringwalkers.ui.patients.profile

import android.content.Intent
import android.os.Bundle
import com.upc.monitoringwalkers.R
import com.upc.monitoringwalkers.model.MWCurrentUser
import com.upc.monitoringwalkers.model.getCurrentUserPreferenceObjectJson
import com.upc.monitoringwalkers.model.setCurrentUserPreferenceObject
import com.upc.monitoringwalkers.patientProfilePresenter
import com.upc.monitoringwalkers.ui.base.BaseActivity
import com.upc.monitoringwalkers.ui.login.LoginActivity
import com.upc.monitoringwalkers.ui.patients.profile.view.PatientProfileView
import kotlinx.android.synthetic.main.activity_patient_profile.*

class PatientProfileActivity : BaseActivity(), PatientProfileView {

    private val presenter by lazy { patientProfilePresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patient_profile)
        val currentUser = getCurrentUserPreferenceObjectJson(this)
        patient_profile_welcome_text.text = "Bienvenido, paciente con codigo ${currentUser.id}"
        patient_profile_logout_btn.setOnClickListener {
            setCurrentUserPreferenceObject(this, MWCurrentUser())
            finish()
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}
