package com.upc.monitoringwalkers.ui.login

import android.os.Bundle
import com.upc.monitoringwalkers.R
import com.upc.monitoringwalkers.common.onTextChanged
import com.upc.monitoringwalkers.common.shortToast
import com.upc.monitoringwalkers.common.showGeneralError
import com.upc.monitoringwalkers.loginPresenter
import com.upc.monitoringwalkers.model.MWCurrentUser
import com.upc.monitoringwalkers.model.setCurrentUserPreferenceObject
import com.upc.monitoringwalkers.ui.base.BaseActivity
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

    //endregion
}
