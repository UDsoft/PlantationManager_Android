package com.udsoft.plantationmanager

import android.app.Application
import com.udsoft.plantationmanager.Shared_Preferences.MainPreferencs

/**
 * Created by darwin on 10/31/17.
 */

val mainPrefs: MainPreferencs by lazy {
    App.mainPrefs!!
}

class App : Application() {
    companion object {
        var mainPrefs: MainPreferencs? = null
    }

    override fun onCreate() {
        mainPrefs = MainPreferencs(applicationContext)
        super.onCreate()
    }
}