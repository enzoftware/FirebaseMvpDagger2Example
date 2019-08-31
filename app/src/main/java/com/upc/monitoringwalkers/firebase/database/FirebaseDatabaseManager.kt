package com.upc.monitoringwalkers.firebase.database

import com.google.firebase.database.FirebaseDatabase
import javax.inject.Inject

class FirebaseDatabaseManager @Inject constructor(private val authentication: FirebaseDatabase) :
    FirebaseDatabaseInterface