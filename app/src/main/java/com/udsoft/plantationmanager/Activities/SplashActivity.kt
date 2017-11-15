package com.udsoft.plantationmanager.Activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.udsoft.plantationmanager.R

class SplashActivity : AppCompatActivity() {

    private val TAG = "SplashActivity"
    private lateinit var appAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        appAuth = FirebaseAuth.getInstance()
    }

    override fun onStart() {
        super.onStart()
        val currentUser: FirebaseUser? = appAuth.currentUser
        updateUI(currentUser)

    }

    fun updateUI(currentUser: FirebaseUser?) {

        if (currentUser == null) {
            val loginScreenIntent = Intent(this, LoginActivity::class.java)
            Log.d(TAG, "starting to go to login")
            startActivity(loginScreenIntent)
        } else {
            val profileScreenIntent = Intent(this, ProfileActivity::class.java)
            Log.d(TAG, "starting to got profile")
            startActivity(profileScreenIntent)
        }

    }
}
