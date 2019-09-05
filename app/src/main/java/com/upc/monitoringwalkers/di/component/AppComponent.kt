package com.upc.monitoringwalkers.di.component

import com.upc.monitoringwalkers.di.module.PresentationModule
import com.upc.monitoringwalkers.ui.admin.addDoctor.presenter.AddDoctorPresenter
import com.upc.monitoringwalkers.ui.admin.listDoctors.presenter.ListDoctorsPresenter
import com.upc.monitoringwalkers.ui.doctor.addPacient.presenter.AddPatientPresenter
import com.upc.monitoringwalkers.ui.login.presenter.LoginPresenter
import com.upc.monitoringwalkers.ui.patients.profile.presenter.PatientProfilePresenter
import com.upc.monitoringwalkers.ui.splash.presenter.SplashPresenter
import dagger.Component
import javax.inject.Singleton

@Component(modules = [PresentationModule::class])
@Singleton
interface AppComponent {

    fun loginPresenter(): LoginPresenter

    fun registerPresenter(): AddPatientPresenter

    fun splashPresenter(): SplashPresenter

    fun addDoctorPresenter(): AddDoctorPresenter

    fun listDoctorsPresenter(): ListDoctorsPresenter

    fun patientProfilePresenter(): PatientProfilePresenter
}