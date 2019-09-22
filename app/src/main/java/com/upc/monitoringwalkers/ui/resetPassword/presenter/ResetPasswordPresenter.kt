package com.upc.monitoringwalkers.ui.resetPassword.presenter

import com.upc.monitoringwalkers.ui.base.BasePresenter
import com.upc.monitoringwalkers.ui.resetPassword.view.ResetPasswordView

interface ResetPasswordPresenter : BasePresenter<ResetPasswordView> {

    fun onResetPasswordClicked(email: String)

}