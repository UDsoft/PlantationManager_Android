package com.udsoft.plantationmanager.Activities

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.udsoft.plantationmanager.R
import kotlinx.android.synthetic.main.general_toolbar.*

class LoginActivity : AppCompatActivity() {

    val loginButton = R.id.login_btn

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        //Theme Text color is black. Couldn't figure out how to change the title color using XML.
        // Changed it in code.
        //todo : How to implement toolbar title color change using xml
        login_toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(login_toolbar)
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
