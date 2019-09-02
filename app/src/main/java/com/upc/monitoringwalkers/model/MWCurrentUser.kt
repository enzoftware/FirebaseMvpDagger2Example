package com.upc.monitoringwalkers.model

import android.content.Context
import android.preference.PreferenceManager
import com.google.gson.Gson


data class MWCurrentUser(val id: String = "", val type: String = "")

fun setCurrentUserPreferenceObject(context: Context, currentUser: MWCurrentUser, key: String) {
    val appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(
        context.applicationContext
    )
    val prefsEditor = appSharedPrefs.edit()
    val gson = Gson()
    val jsonObject = gson.toJson(currentUser)
    prefsEditor.putString(key, jsonObject)
    prefsEditor.apply()

}

fun getCurrentUserPreferenceObjectJson(context: Context, key: String): MWCurrentUser {
    val appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(
        context.applicationContext
    )
    val json = appSharedPrefs.getString(key, "")
    val gson = Gson()
    return if (json != "") gson.fromJson<MWCurrentUser>(json, MWCurrentUser::class.java) else MWCurrentUser()
}
