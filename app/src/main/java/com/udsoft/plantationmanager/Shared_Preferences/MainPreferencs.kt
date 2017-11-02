package com.udsoft.plantationmanager.Shared_Preferences

import android.content.Context
import android.content.SharedPreferences
import java.security.AccessControlContext

/**
 * Created by darwin on 10/31/17.
 */
class MainPreferencs(context: Context) {
    private val PREFS_FILENAME = "com.udsoft.plantationmanager.main"
    private val FIRST_NAME = "first_name"
    private val LAST_NAME = "last_name"
    private val PASSWORD = "password"
    private val EMAIL = "email_address"
    private val DATE_OF_BIRTH = "date_of_birth"
    private val LOGGED = "user_Logged"
    private val prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME, 0)

    var firstname: String
        get() = prefs.getString(FIRST_NAME, "N/A")
        set(value) = prefs.edit().putString(FIRST_NAME, value).apply()

    var lastname: String
        get() = prefs.getString(LAST_NAME, "N/A")
        set(value) = prefs.edit().putString(LAST_NAME, value).apply()

    var password: String
        get() = prefs.getString(PASSWORD, "N/A")
        set(value) = prefs.edit().putString(PASSWORD, value).apply()

    var email: String
        get() = prefs.getString(EMAIL, "N/A")
        set(value) = prefs.edit().putString(EMAIL, value).apply()

    var dob: String
        get() = prefs.getString(DATE_OF_BIRTH, "N/A")
        set(value) = prefs.edit().putString(DATE_OF_BIRTH, value).apply()


    //True if the user is logged
    //False if the user is logged of or no user is registered.
    var isLogged: Boolean
        get() = prefs.getBoolean(LOGGED, false)
        set(value) = prefs.edit().putBoolean(LOGGED, value).apply()


}