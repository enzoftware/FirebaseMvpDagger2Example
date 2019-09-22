package com.upc.monitoringwalkers.ui.resetPassword

import android.os.Bundle
import com.upc.monitoringwalkers.R
import com.upc.monitoringwalkers.common.shortToast
import com.upc.monitoringwalkers.resetPasswordPresenter
import com.upc.monitoringwalkers.ui.base.BaseActivity
import com.upc.monitoringwalkers.ui.resetPassword.view.ResetPasswordView
import kotlinx.android.synthetic.main.activity_reset_password.*

class ResetPasswordActivity : BaseActivity(), ResetPasswordView {

    private val presenter by lazy { resetPasswordPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)
        supportActionBar.run {
            this!!.setDefaultDisplayHomeAsUpEnabled(true)
            title = "Recuperar contraseña"
        }
        presenter.setView(this)

        initUi()
    }

    private fun initUi() {
        reset_password_btn.setOnClickListener {
            presenter.onResetPasswordClicked(reset_password_edit_text.text.toString().trim())
        }
    }

    override fun onResetSuccess() {
        shortToast(this, "Se envio el correo a la direccion indicada")
    }

    override fun onResetFail() {
        shortToast(this, "Hubo un error")
    }


}
