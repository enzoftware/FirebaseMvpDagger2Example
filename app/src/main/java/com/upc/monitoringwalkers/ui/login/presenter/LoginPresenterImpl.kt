package com.upc.monitoringwalkers.ui.login.presenter

import com.upc.monitoringwalkers.firebase.authentication.FirebaseAuthenticationInterface
import com.upc.monitoringwalkers.ui.login.view.LoginView
import javax.inject.Inject

class LoginPresenterImpl @Inject constructor(
    private val authentication: FirebaseAuthenticationInterface
) : LoginPresenter {

    override fun onLoginClicked() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onEmailChanged(email: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPasswordChanged(password: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setView(view: LoginView) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}