package com.upc.monitoringwalkers.ui.resetPassword.presenter

import com.upc.monitoringwalkers.firebase.authentication.FirebaseAuthenticationInterface
import com.upc.monitoringwalkers.ui.resetPassword.view.ResetPasswordView
import javax.inject.Inject

class ResetPasswordPresenterImpl @Inject constructor(
    private val authentication: FirebaseAuthenticationInterface
) : ResetPasswordPresenter {

    private lateinit var resetPasswordView: ResetPasswordView

    override fun setView(view: ResetPasswordView) {
        resetPasswordView = view
    }

    override fun onResetPasswordClicked(email: String) {
        authentication.resetPassword(email) {
            if (it) resetPasswordView.onResetSuccess() else resetPasswordView.onResetFail()
        }
    }
}