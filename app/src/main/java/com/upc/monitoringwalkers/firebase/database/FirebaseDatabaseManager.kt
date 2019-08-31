package com.upc.monitoringwalkers.firebase.database

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.upc.monitoringwalkers.model.Patient
import javax.inject.Inject

private const val KEY_USER = "user"

class FirebaseDatabaseManager @Inject constructor(private val database: FirebaseDatabase) :
    FirebaseDatabaseInterface {

    override fun getPatientProfile(id: String, onResult: (Patient) -> Unit) {
        database.reference.child(KEY_USER).child(id).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

            }

            override fun onCancelled(p0: DatabaseError) = Unit
        })
    }

    override fun createPatient(patient: Patient) {
        database.reference.child(KEY_USER).child(patient.id).setValue(patient)
    }

}