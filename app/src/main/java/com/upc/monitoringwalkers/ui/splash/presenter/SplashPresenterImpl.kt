package com.upc.monitoringwalkers.ui.splash.presenter

import com.upc.monitoringwalkers.firebase.authentication.FirebaseAuthenticationInterface
import com.upc.monitoringwalkers.firebase.database.FirebaseDatabaseInterface
import com.upc.monitoringwalkers.ui.splash.view.SplashView
import javax.inject.Inject

class SplashPresenterImpl @Inject constructor(
    private val databaseInterface: FirebaseDatabaseInterface,
    authenticationInterface: FirebaseAuthenticationInterface
) : SplashPresenter {

    private lateinit var view: SplashView

    private val currentUserId = authenticationInterface.getUserId()


    override fun decideWhereToGo() {
        databaseInterface.getUserType(currentUserId) { type ->
            when (type) {
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