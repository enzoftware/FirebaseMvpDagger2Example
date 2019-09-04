package com.upc.monitoringwalkers.model

import android.content.Context
import android.preference.PreferenceManager
import com.google.gson.Gson


data class MWCurrentUser(val id: String = "", val type: String = "")

private const val KEY_CURRENT_USER = "currentUser"

fun setCurrentUserPreferenceObject(context: Context, currentUser: MWCurrentUser) {
    val appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(
        context.applicationContext
    )
    val prefsEditor = appSharedPrefs.edit()
    val gson = Gson()
    val jsonObject = gson.toJson(currentUser)
    prefsEditor.putString(KEY_CURRENT_USER, jsonObject)
    prefsEditor.apply()

}

fun getCurrentUserPreferenceObjectJson(context: Context): MWCurrentUser {
    val appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(
        context.applicationContext
    )
    val json = appSharedPrefs.getString(KEY_CURRENT_USER, "")
    val gson = Gson()
    return if (json != "") gson.fromJson<MWCurrentUser>(json, MWCurrentUser::class.java) else MWCurrentUser()
}
