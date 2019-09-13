package com.upc.monitoringwalkers.firebase.database

import android.util.Log
import com.google.firebase.database.*
import com.upc.monitoringwalkers.model.*
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
                    onResult(
                        PatientEntity(
                            id,
                            name,
                            lastName,
                            email,
                            type,
                            age,
                            treatment,
                            weight,
                            affectation,
                            doctorId
                        )
                    )
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

    }

    override fun listenToDoctors(onResult: (DoctorEntity) -> Unit) {
        database.reference.child(KEY_USER)
            .orderByChild(KEY_TYPE_USER).equalTo(KEY_DOCTOR)
            .addChildEventListener(object : ChildEventListener {
                override fun onCancelled(error: DatabaseError) = Unit
                override fun onChildMoved(snapshot: DataSnapshot, p1: String?) = Unit

                override fun onChildChanged(snapshot: DataSnapshot, p1: String?) {
                    snapshot.getValue(DoctorEntity::class.java)?.run {
                        if (isValid()) {
                            Log.i(
                                "doctorInfo",
                                "${this.name} ${this.email} ${this.lastName} ${snapshot.key} ${this.type}"
                            )
                            onResult(mapToDoctor())
                        }
                    }
                }

                override fun onChildRemoved(snapshot: DataSnapshot) {
                    snapshot.getValue(DoctorEntity::class.java)?.run {
                        if (isValid()) {
                            Log.i(
                                "doctorInfo",
                                "${this.name} ${this.email} ${this.lastName} ${snapshot.key} ${this.type}"
                            )
                            onResult(mapToDoctor())
                        }
                    }
                }

                override fun onChildAdded(snapshot: DataSnapshot, p1: String?) {
                    snapshot.getValue(DoctorEntity::class.java)?.run {
                        if (isValid()) {
                            Log.i(
                                "doctorInfo",
                                "${this.name} ${this.email} ${this.lastName} ${snapshot.key} ${this.type}"
                            )
                            onResult(mapToDoctor())
                        }
                    }
                }
            })
    }

    override fun listenToPatientByDoctor(doctorId: String, onResult: (PatientEntity) -> Unit) {
        database.reference.child(KEY_USER).orderByChild("doctorId").equalTo(doctorId)
            .addChildEventListener(object : ChildEventListener {
                override fun onCancelled(error: DatabaseError) = Unit

                override fun onChildMoved(snapshot: DataSnapshot, p1: String?) = Unit

                override fun onChildChanged(snapshot: DataSnapshot, p1: String?) {
                    snapshot.getValue(PatientEntity::class.java)?.run {
                        if (isValid()) {
                            Log.i(
                                "patientInfo",
                                "${this.name} ${this.email} ${this.lastName} ${snapshot.key} ${this.type}"
                            )
                            onResult(mapToPatient())
                        }
                    }
                }

                override fun onChildAdded(snapshot: DataSnapshot, p1: String?) {
                    snapshot.getValue(PatientEntity::class.java)?.run {
                        if (isValid()) {
                            Log.i(
                                "patientInfo",
                                "${this.name} ${this.email} ${this.lastName} ${snapshot.key} ${this.type}"
                            )
                            onResult(mapToPatient())
                        }
                    }
                }

                override fun onChildRemoved(snapshot: DataSnapshot) {
                    snapshot.getValue(PatientEntity::class.java)?.run {
                        if (isValid()) {
                            Log.i(
                                "patientInfo",
                                "${this.name} ${this.email} ${this.lastName} ${snapshot.key} ${this.type}"
                            )
                            onResult(mapToPatient())
                        }
                    }
                }
            })
    }
}