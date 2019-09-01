package com.upc.monitoringwalkers.ui.splash.presenter

import com.upc.monitoringwalkers.ui.base.BasePresenter
import com.upc.monitoringwalkers.ui.splash.view.SplashView

interface SplashPresenter : BasePresenter<SplashView> {
    fun decideWhereToGo()
}