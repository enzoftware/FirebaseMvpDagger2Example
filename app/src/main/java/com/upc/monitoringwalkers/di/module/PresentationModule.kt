package com.upc.monitoringwalkers.di.module

import com.upc.monitoringwalkers.ui.admin.addDoctor.presenter.AddDoctorPresenter
import com.upc.monitoringwalkers.ui.admin.addDoctor.presenter.AddDoctorPresenterImpl
import com.upc.monitoringwalkers.ui.doctor.addPacient.presenter.AddPatientPresenter
import com.upc.monitoringwalkers.ui.doctor.addPacient.presenter.AddPatientPresenterImpl
import com.upc.monitoringwalkers.ui.login.presenter.LoginPresenter
import com.upc.monitoringwalkers.ui.login.presenter.LoginPresenterImpl
import com.upc.monitoringwalkers.ui.splash.presenter.SplashPresenter
import com.upc.monitoringwalkers.ui.splash.presenter.SplashPresenterImpl
import dagger.Binds
import dagger.Module

@Module(includes = [InteractionModule::class])
abstract class PresentationModule {
    @Binds
    abstract fun loginPresenter(loginPresenter: LoginPresenterImpl): LoginPresenter

    @Binds
    abstract fun registerPresenter(registerPresenter: AddPatientPresenterImpl): AddPatientPresenter

    @Binds
    abstract fun splashPresenter(splashPresenter: SplashPresenterImpl): SplashPresenter

    @Binds
    abstract fun addDoctorPresenter(addDoctorPresenter: AddDoctorPresenterImpl): AddDoctorPresenter
}