package com.upc.monitoringwalkers

import android.app.Application
import com.google.firebase.FirebaseApp
import com.upc.monitoringwalkers.di.component.AppComponent
import com.upc.monitoringwalkers.di.component.DaggerAppComponent

class MonitoringWalkersApp : Application() {

    companion object {
        lateinit var instance: MonitoringWalkersApp
            private set
        val component: AppComponent by lazy { DaggerAppComponent.builder().build() }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        FirebaseApp.initializeApp(this)
    }
}