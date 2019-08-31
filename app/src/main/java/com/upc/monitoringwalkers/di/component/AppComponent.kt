package com.upc.monitoringwalkers.di.component

import com.upc.monitoringwalkers.di.module.PresentationModule
import com.upc.monitoringwalkers.ui.login.presenter.LoginPresenter
import dagger.Component
import javax.inject.Singleton

@Component(modules = [PresentationModule::class])
@Singleton
interface AppComponent {
    fun loginPresenter(): LoginPresenter
}