package com.upc.monitoringwalkers.firebase.database

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.upc.monitoringwalkers.model.DoctorEntity
import com.upc.monitoringwalkers.model.PatientEntity
import javax.inject.Inject

private const val KEY_USER = "user"

class FirebaseDatabaseManager @Inject constructor(private val database: FirebaseDatabase) :
    FirebaseDatabaseInterface {

    override fun getUserType(id: String, onResult: (String) -> Unit) {
        database.reference.child(KEY_USER).child(id).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val userType = snapshot.child("type").value
                print(userType)
                onResult(userType.toString())
            }

            override fun onCancelled(p0: DatabaseError) = Unit
        })
    }

    override fun getDoctorProfile(id: String, onResult: (DoctorEntity) -> Unit) {
        database.reference.child(KEY_USER).child(id).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val user = snapshot.getValue(DoctorEntity::class.java)
                user?.run {
                    onResult(DoctorEntity(id, name, lastName, password, email, type, username))
                }
            }

            override fun onCancelled(p0: DatabaseError) = Unit
        })
    }

    override fun getPatientProfile(id: String, onResult: (PatientEntity) -> Unit) {
        database.reference.child(KEY_USER).child(id).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val user = snapshot.getValue(PatientEntity::class.java)
                user?.run {
                    onResult(PatientEntity(id, name, lastName, email, type, age, treatment))
                }
            }
            override fun onCancelled(p0: DatabaseError) = Unit
        })
    }


    override fun createPatient(patientEntity: PatientEntity) {
        database.reference.child(KEY_USER).child(patientEntity.id).setValue(patientEntity)
    }

}