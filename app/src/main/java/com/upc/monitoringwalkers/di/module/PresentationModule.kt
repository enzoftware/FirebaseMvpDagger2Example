package com.upc.monitoringwalkers.di.module

import com.upc.monitoringwalkers.ui.login.presenter.LoginPresenter
import com.upc.monitoringwalkers.ui.login.presenter.LoginPresenterImpl
import dagger.Binds
import dagger.Module

@Module(includes = [InteractionModule::class])
abstract class PresentationModule {
    @Binds
    abstract fun loginPresenter(loginPresenter: LoginPresenterImpl): LoginPresenter
}