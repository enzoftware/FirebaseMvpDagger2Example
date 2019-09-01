package com.upc.monitoringwalkers.firebase.database

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.upc.monitoringwalkers.model.DoctorEntity
import com.upc.monitoringwalkers.model.PatientEntity
import com.upc.monitoringwalkers.model.mapToDoctor
import javax.inject.Inject

private const val KEY_USER = "user"
private const val KEY_TYPE_USER = "type"
private const val KEY_DOCTOR = "DOCTOR"


class FirebaseDatabaseManager @Inject constructor(private val database: FirebaseDatabase) :
    FirebaseDatabaseInterface {

    override fun getUserType(id: String, onResult: (String) -> Unit) {
        database.reference.child(KEY_USER).child(id).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val userType = snapshot.child(KEY_TYPE_USER).value
                onResult(userType.toString())
            }

            override fun onCancelled(error: DatabaseError) = Unit
        })
    }

    override fun getDoctorProfile(id: String, onResult: (DoctorEntity) -> Unit) {
        database.reference.child(KEY_USER).child(id).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val user = snapshot.getValue(DoctorEntity::class.java)
                user?.run {
                    onResult(DoctorEntity(id, name, lastName, email, type))
                }
            }

            override fun onCancelled(error: DatabaseError) = Unit
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

            override fun onCancelled(error: DatabaseError) = Unit
        })
    }


    override fun createPatient(patientEntity: PatientEntity) {
        database.reference.child(KEY_USER).child(patientEntity.id).setValue(patientEntity)
    }

    override fun createDoctor(doctorEntity: DoctorEntity) {
        database.reference.child(KEY_USER).child(doctorEntity.id).setValue(doctorEntity)
    }

    override fun getAllDoctors(onResult: (List<DoctorEntity>) -> Unit) {
        database.reference.child(KEY_USER).orderByChild(KEY_TYPE_USER).equalTo(KEY_DOCTOR)
            .addValueEventListener(object : ValueEventListener {
                override fun onCancelled(error: DatabaseError) = onResult(listOf())

                override fun onDataChange(snapshot: DataSnapshot) {
                    snapshot.run {
                        val doctors = children.mapNotNull { it.getValue(DoctorEntity::class.java) }
                        onResult(doctors.map(DoctorEntity::mapToDoctor))
                    }
                }
            })
    }

    override fun getPatientsByDoctor(doctorId: String, onResult: (List<PatientEntity>) -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}