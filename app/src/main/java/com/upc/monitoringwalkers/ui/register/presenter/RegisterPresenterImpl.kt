package com.upc.monitoringwalkers.ui.register.presenter

import com.upc.monitoringwalkers.firebase.authentication.FirebaseAuthenticationInterface
import com.upc.monitoringwalkers.firebase.database.FirebaseDatabaseInterface
import com.upc.monitoringwalkers.ui.register.view.RegisterView
import javax.inject.Inject

class RegisterPresenterImpl @Inject constructor(
    private val databaseInterface: FirebaseDatabaseInterface,
    private val authenticationInterface: FirebaseAuthenticationInterface
) : RegisterPresenter {

    private lateinit var view: RegisterView

    override fun setView(view: RegisterView) {
        this.view = view
    }

    override fun onUsernameChanged(username: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onEmailChanged(email: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPasswordChanged(password: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onRepeatPasswordChanged(repeatPassword: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onRegisterClicked() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}