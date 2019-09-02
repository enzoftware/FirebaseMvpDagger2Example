package com.upc.monitoringwalkers.ui.login.presenter

import android.util.Log
import com.upc.monitoringwalkers.common.isEmailValid
import com.upc.monitoringwalkers.common.isPasswordValid
import com.upc.monitoringwalkers.firebase.authentication.FirebaseAuthenticationInterface
import com.upc.monitoringwalkers.firebase.database.FirebaseDatabaseInterface
import com.upc.monitoringwalkers.model.LoginModel
import com.upc.monitoringwalkers.model.MWCurrentUser
import com.upc.monitoringwalkers.ui.login.view.LoginView
import javax.inject.Inject

class LoginPresenterImpl @Inject constructor(
    private val authentication: FirebaseAuthenticationInterface,
    private val databaseInterface: FirebaseDatabaseInterface
) : LoginPresenter {

    private lateinit var view: LoginView
    private val loginModel = LoginModel()

    override fun onLoginClicked() {
        if (loginModel.isValid()) {
            authentication.login(loginModel.email, loginModel.password) { isSuccess, userId ->
                if (isSuccess) {
                    databaseInterface.getUserType(userId) {
                        Log.i("userInfo", it)
                        val currentUser = MWCurrentUser(userId, it)
                        view.onLoginSuccess(currentUser)
                    }
                } else {
                    view.onLoginError()
                }
            }
        }
    }

    override fun onEmailChanged(email: String) {
        loginModel.email = email
        if (!isEmailValid(email)) {
            view.showEmailError()
        }
    }

    override fun onPasswordChanged(password: String) {
        loginModel.password = password
        if (!isPasswordValid(password)) {
            view.showPasswordError()
        }
    }

    override fun setView(view: LoginView) {
        this.view = view
    }
}