package com.udsoft.plantationmanager.Activities

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.udsoft.plantationmanager.R
import kotlinx.android.synthetic.main.general_toolbar.*
import kotlinx.android.synthetic.main.login_content.*
import org.jetbrains.anko.toast

class LoginActivity : AppCompatActivity() {

    val appAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
        //todo : How to implement toolbar title color change using xml
        general_toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(general_toolbar)
        val loginBtn = findViewById<Button>(R.id.login_btn)
        loginBtn.setOnClickListener { attemptlogin() }


        //todo : only temporary intent... Please Remove
        val tempTest = Intent(this, AddHarvest::class.java)
        startActivity(tempTest)

    }


    fun attemptlogin() {
        val email = login_input_email.text.toString()
        val password = login_input_password.text.toString()
        if (handleError(email = email, password = password)) {
            this.appAuth.signInWithEmailAndPassword(email, password).
                    addOnCompleteListener { task: Task<AuthResult> ->
                        if (task.isSuccessful) {
                            val intentToProfile = Intent(this, ProfileActivity::class.java)
                            startActivity(intentToProfile)
                        } else {
                            toast(getString(R.string.login_error))
                        }
                    }
        }

    }


    private fun handleError(email: String, password: String): Boolean {
        var isValidInput = true

        if (email.isNullOrEmpty()) {
            toast("${R.string.action_email} ${R.string.is_empty}")
            isValidInput = false
        } else {
            if (android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                toast(getString(R.string.invalid_email))
                isValidInput = false
            }
        }
        if (password.isNullOrEmpty()) {
            toast("${R.string.action_password} ${R.string.is_empty}")
            isValidInput = false
        }

        return isValidInput
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.login_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //todo : write a function which deal with text of the button turning white as it is in focus


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.btn_register_new_user -> {
                val registerIntent = Intent(this, RegisterActivity::class.java)
                startActivity(registerIntent)

            }
        }

        return super.onOptionsItemSelected(item)
    }
}
