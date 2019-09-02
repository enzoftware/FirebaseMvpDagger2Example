package com.upc.monitoringwalkers.ui.splash.presenter

import android.content.Context
import com.upc.monitoringwalkers.model.MWCurrentUser
import com.upc.monitoringwalkers.model.getCurrentUserPreferenceObjectJson
import com.upc.monitoringwalkers.ui.splash.view.SplashView

class SplashPresenterImpl : SplashPresenter {
    private lateinit var view: SplashView

    override fun decideWhereToGo(context: Context) {
        val currentUser: MWCurrentUser? = getCurrentUserPreferenceObjectJson(context, "currentUser")
        when {
            currentUser == null -> view.onCurrentUserIsEmpty()
            currentUser.id.isEmpty() -> view.onCurrentUserIsEmpty()
            else -> when (currentUser.type) {
                "PATIENT" -> {
                    view.onCurrentUserIsPacient()
                }
                "DOCTOR" -> {
                    view.onCurrentUserIsDoctor()
                }
                "ADMIN" -> {
                    view.onCurrentUserIsAdmin()
                }
                else -> {
                    view.onCurrentUserIsEmpty()
                }
            }
        }
    }

    override fun setView(view: SplashView) {
        this.view = view
    }
}