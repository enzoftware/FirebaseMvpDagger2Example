package com.upc.monitoringwalkers.firebase.authentication

import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class FirebaseAuthenticationManager @Inject constructor(private val authentication: FirebaseAuth) :
    FirebaseAuthenticationInterface