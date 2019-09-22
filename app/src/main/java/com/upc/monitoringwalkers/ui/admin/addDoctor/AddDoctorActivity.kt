package com.upc.monitoringwalkers.ui.admin.addDoctor

import android.os.Bundle
import com.upc.monitoringwalkers.R
import com.upc.monitoringwalkers.addDoctorPresenter
import com.upc.monitoringwalkers.common.onTextChanged
import com.upc.monitoringwalkers.common.shortToast
import com.upc.monitoringwalkers.common.showGeneralError
import com.upc.monitoringwalkers.ui.admin.addDoctor.view.AddDoctorView
import com.upc.monitoringwalkers.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_add_doctor.*


class AddDoctorActivity : BaseActivity(), AddDoctorView {

    private val presenter by lazy { addDoctorPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_doctor)
        presenter.setView(this)
        initUi()
    }

    private fun initUi() {
        register_doctor_email_edit.onTextChanged {
            presenter.onEmailChanged(it!!)
        }
        register_doctor_password_edit.onTextChanged {
            presenter.onPasswordChanged(it!!)
        }
        register_doctor_confirm_password_edit.onTextChanged {
            presenter.onRepeatPasswordChanged(it!!)
        }
        register_doctor_name_edit.onTextChanged {
            presenter.onNameChanged(it!!)
        }
        register_doctor_last_name_edit.onTextChanged {
            presenter.onLastNameChanged(it!!)
        }
        material_button_register_doctor.setOnClickListener {
            showLoadingDialog()
            presenter.onRegisterClicked()
        }
        supportActionBar!!.setTitle(R.string.add_doctor)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onRegisterSuccess() {
        hideLoadingDialog()
        shortToast(this, "Registro doctor exitoso")
        onBackPressed()
    }

    override fun showSignUpError() {
        hideLoadingDialog()
        showGeneralError(this)
    }

    override fun showEmailError() {
        register_doctor_email_edit.error = getString(R.string.email_error)
    }

    override fun showPasswordError() {
        register_doctor_password_edit.error = getString(R.string.password_error)
    }

    override fun showPasswordMatchingError() {
        register_doctor_confirm_password_edit.error = getString(R.string.password_error)
    }
}
