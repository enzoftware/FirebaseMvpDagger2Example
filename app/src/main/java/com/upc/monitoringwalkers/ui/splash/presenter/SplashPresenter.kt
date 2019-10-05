package com.upc.monitoringwalkers.ui.splash.presenter

import android.content.Context
import com.upc.monitoringwalkers.ui.base.BasePresenter
import com.upc.monitoringwalkers.ui.splash.view.SplashView

interface SplashPresenter : BasePresenter<SplashView> {
    /**
     * Based on the current info about the user decide which screen go
     *
     * @param context
     */
    fun decideWhereToGo(context: Context)
}