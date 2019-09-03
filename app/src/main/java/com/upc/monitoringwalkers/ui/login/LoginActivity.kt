package com.upc.monitoringwalkers.ui.login

import android.content.Intent
import android.os.Bundle
import com.upc.monitoringwalkers.R
import com.upc.monitoringwalkers.common.onTextChanged
import com.upc.monitoringwalkers.common.shortToast
import com.upc.monitoringwalkers.common.showGeneralError
import com.upc.monitoringwalkers.loginPresenter
import com.upc.monitoringwalkers.model.MWCurrentUser
import com.upc.monitoringwalkers.model.setCurrentUserPreferenceObject
import com.upc.monitoringwalkers.ui.admin.addDoctor.AddDoctorActivity
import com.upc.monitoringwalkers.ui.base.BaseActivity
import com.upc.monitoringwalkers.ui.doctor.addPacient.AddPatientActivity
import com.upc.monitoringwalkers.ui.login.view.LoginView
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(), LoginView {

    private val presenter by lazy { loginPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        // Initialize the view
        presenter.setView(this)

        initUi()
    }

    private fun initUi() {
        login_email_edit.onTextChanged {
            presenter.onEmailChanged(it!!)
        }
        login_password_edit.onTextChanged {
            presenter.onPasswordChanged(it!!)
        }
        material_button_login.setOnClickListener {
            presenter.onLoginClicked()
        }
    }

    //region View Callbacks

    override fun onLoginSuccess(currentUser: MWCurrentUser) {
        setCurrentUserPreferenceObject(this, currentUser, "currentUser")
        when (currentUser.type) {
            "DOCTOR" -> onCurrentUserIsDoctor()
            "PATIENT" -> onCurrentUserIsPatient()
            "ADMIN" -> onCurrentUserIsAdmin()
            else -> showGeneralError(this)
        }
        shortToast(this, "Inicio de sesion exitoso")
    }

    override fun onLoginError() {
        showGeneralError(this)
    }

    override fun showEmailError() {
        login_email_edit.error = getString(R.string.email_error)
    }

    override fun showPasswordError() {
        login_password_edit.error = getString(R.string.password_error)
    }

    override fun onCurrentUserIsDoctor() {
        startActivity(Intent(this, AddPatientActivity::class.java))
        shortToast(this, "Usuario doctor")
        finish()
    }

    override fun onCurrentUserIsPatient() {
        //        startActivity(Intent(this, LoginActivity::class.java))
        shortToast(this, "Usuario paciente")
    }

    override fun onCurrentUserIsAdmin() {
        startActivity(Intent(this, AddDoctorActivity::class.java))
        shortToast(this, "Usuario admin")
        finish()
    }

    //endregion
}
