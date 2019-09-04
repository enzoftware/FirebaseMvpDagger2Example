package com.upc.monitoringwalkers.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.upc.monitoringwalkers.R
import com.upc.monitoringwalkers.common.shortToast
import com.upc.monitoringwalkers.splashPresenter
import com.upc.monitoringwalkers.ui.admin.listDoctors.ListDoctorsActivity
import com.upc.monitoringwalkers.ui.base.BaseActivity
import com.upc.monitoringwalkers.ui.doctor.addPacient.AddPatientActivity
import com.upc.monitoringwalkers.ui.login.LoginActivity
import com.upc.monitoringwalkers.ui.patients.profile.PatientProfileActivity
import com.upc.monitoringwalkers.ui.splash.view.SplashView

class SplashActivity : BaseActivity(), SplashView {

    private val presenter by lazy { splashPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFullScreenMode()
        setContentView(R.layout.activity_splash)
        presenter.setView(this)

        initUi()
    }

    private fun initUi() {
        Handler().postDelayed({
            presenter.decideWhereToGo(this)
        }, 3200)
    }

    override fun onCurrentUserIsDoctor() {
        startActivity(Intent(this, AddPatientActivity::class.java))
        shortToast(this, "Usuario doctor")
        finish()
    }

    override fun onCurrentUserIsPatient() {
        startActivity(Intent(this, PatientProfileActivity::class.java))
        shortToast(this, "Usuario paciente")
    }

    override fun onCurrentUserIsAdmin() {
        startActivity(Intent(this, ListDoctorsActivity::class.java))
        shortToast(this, "Usuario admin")
        finish()
    }

    override fun onCurrentUserIsEmpty() {
        startActivity(Intent(this, LoginActivity::class.java))
        shortToast(this, "Usuario desconocido")
        finish()
    }
}
