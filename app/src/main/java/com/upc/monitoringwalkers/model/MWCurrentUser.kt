package com.upc.monitoringwalkers.model

import android.content.Context
import android.preference.PreferenceManager
import com.google.gson.Gson


data class MWCurrentUser(val id: String = "", val type: String = "")

private const val KEY_CURRENT_USER = "currentUser"


/**
 * Save the current user into SharedPreferences
 *
 * @param context Context of the activity
 * @param currentUser Custom user object to be store in the local storage of the device
 */
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

/**
 * Get the MWCustomUser that is store in the local storage
 *
 * @param context Context of the activity
 * @return Custom user object
 */
fun getCurrentUserPreferenceObjectJson(context: Context): MWCurrentUser {
    val appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(
        context.applicationContext
    )
    val json = appSharedPrefs.getString(KEY_CURRENT_USER, "")
    val gson = Gson()
    return if (json != "") gson.fromJson<MWCurrentUser>(json, MWCurrentUser::class.java) else MWCurrentUser()
}
