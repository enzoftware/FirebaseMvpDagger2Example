package com.upc.monitoringwalkers.di.component

import com.upc.monitoringwalkers.di.module.PresentationModule
import com.upc.monitoringwalkers.ui.login.presenter.LoginPresenter
import com.upc.monitoringwalkers.ui.register.presenter.RegisterPresenter
import com.upc.monitoringwalkers.ui.splash.presenter.SplashPresenter
import dagger.Component
import javax.inject.Singleton

@Component(modules = [PresentationModule::class])
@Singleton
interface AppComponent {

    fun loginPresenter(): LoginPresenter

    fun registerPresenter(): RegisterPresenter

    fun splashPresenter(): SplashPresenter
}