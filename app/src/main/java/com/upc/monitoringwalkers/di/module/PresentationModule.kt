package com.upc.monitoringwalkers.di.module

import com.upc.monitoringwalkers.ui.login.presenter.LoginPresenter
import com.upc.monitoringwalkers.ui.login.presenter.LoginPresenterImpl
import com.upc.monitoringwalkers.ui.register.presenter.RegisterPresenter
import com.upc.monitoringwalkers.ui.register.presenter.RegisterPresenterImpl
import com.upc.monitoringwalkers.ui.splash.presenter.SplashPresenter
import com.upc.monitoringwalkers.ui.splash.presenter.SplashPresenterImpl
import dagger.Binds
import dagger.Module

@Module(includes = [InteractionModule::class])
abstract class PresentationModule {
    @Binds
    abstract fun loginPresenter(loginPresenter: LoginPresenterImpl): LoginPresenter

    @Binds
    abstract fun registerPresenter(registerPresenter: RegisterPresenterImpl): RegisterPresenter

    @Binds
    abstract fun splashPresenter(splashPresenter: SplashPresenterImpl): SplashPresenter
}