package com.upc.monitoringwalkers.di.module

import com.upc.monitoringwalkers.firebase.authentication.FirebaseAuthenticationInterface
import com.upc.monitoringwalkers.firebase.authentication.FirebaseAuthenticationManager
import com.upc.monitoringwalkers.firebase.database.FirebaseDatabaseInterface
import com.upc.monitoringwalkers.firebase.database.FirebaseDatabaseManager
import dagger.Binds
import dagger.Module

@Module(includes = [FirebaseModule::class])
abstract class InteractionModule {
    @Binds
    abstract fun authentication(authentication: FirebaseAuthenticationManager): FirebaseAuthenticationInterface

    @Binds
    abstract fun database(database: FirebaseDatabaseManager): FirebaseDatabaseInterface
}