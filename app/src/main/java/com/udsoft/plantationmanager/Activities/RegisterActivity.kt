package com.udsoft.plantationmanager.Activities

import android.accounts.Account
import android.accounts.AccountManager
import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import com.udsoft.plantationmanager.Database.user
import com.udsoft.plantationmanager.R
import com.udsoft.plantationmanager.mainPrefs
import kotlinx.android.synthetic.main.register_activity.*

class RegisterActivity : AppCompatActivity() {

    private val TAG: String = "RegisterActivity_Class"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_activity)
        toolbar_register.setTitleTextColor(Color.WHITE)
        setSupportActionBar(toolbar_register)
        btn_dob_calender.setOnClickListener { }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.register_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    /**
     * Check if the all the registration value is valid before saving it to data class user.
     * @param return with all the valid user input the new user will be created.In non valid situation a null user will be created.
     * @param firstname is the first name of the user
     * @param lastname is the last name of the user
     * @param email is the email address oof the user. Email format will be checked for verification is valid when contains "@".
     * @param password is the password for the account. Valid when more or equal to 6 characters.
     * @param retypepassword is used to ensure user don't enter wrong password as they actually meant.
     * @param dob is the date of birth of the user.
     */
    private fun validateUserInput(): user? {
        //Extract all the information filled up by the user in the register_activity layout.
        val firstName: String = input_first_name_register.text.toString()
        val lastName: String = input_last_name_register.text.toString()
        val email: String = input_email_register.text.toString()
        val password: String = input_password_register.text.toString()
        val retypePassword: String = input_retype_password_register.text.toString()
        val dob: String = show_dob.text.toString()

        fun errorToast(message: CharSequence) =
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

        /**
         * Rules
         * 1. No variable is empty.
         * 2. email format is valid
         * 3. date of birthday format is valid.
         */
        //1.Ensure no variable is empty.
        val generalEmptyErrorMessage = getString(R.string.is_empty)

        fun isContentEmpty(): Boolean {
            when {
                firstName.isNullOrEmpty() -> {
                    errorToast("${getString(R.string.action_first_name)} $generalEmptyErrorMessage")
                    return true
                }
                lastName.isNullOrEmpty() -> {
                    errorToast("${getString(R.string.action_last_name)} $generalEmptyErrorMessage")
                    return true
                }
                email.isNullOrEmpty() -> {
                    errorToast("${getString(R.string.action_email)} $generalEmptyErrorMessage")
                    return true
                }
                password.isNullOrEmpty() -> {
                    errorToast("${getString(R.string.action_password)} $generalEmptyErrorMessage")
                    return true
                }
                dob.isNullOrEmpty() -> {
                    errorToast("${getString(R.string.action_date_of_birth)} $generalEmptyErrorMessage")
                    return true
                }
                else -> return false
            }
        }

        //2. email format is valid
        fun isEmailValid(): Boolean {
            return (android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
        }

        fun isPasswordValid(): Boolean {

            when {
                !password.equals(retypePassword) -> {
                    errorToast(getString(R.string.password_mismatch))
                    register_password_box.error = getString(R.string.password_mismatch)
                    register_retype_password_box.error = getString(R.string.password_mismatch)
                    Log.d(TAG, "Password didn't match Retype password")
                    return false
                }

                password.length < 6 -> {
                    errorToast(getString(R.string.error_password_length_short))
                    register_password_box.error = getString(R.string.error_password_length_short)
                    Log.d(TAG, "Password length less than 6")
                    return false
                }
                else -> return true
            }

        }


        //Check list of validation
        when {
        //1. check for empty input
            isContentEmpty() -> {
                Log.d(TAG, "There is Empty input")
                return null
            }
        //2. check for invalid email format
            !isEmailValid() -> {
                errorToast(getString(R.string.wrong_email))
                Log.d(TAG, "Email is not right format")
                return null
            }
        //3. ensure password matches with the retype password and more or equal to 6 characters.
            !isPasswordValid() -> {
                return null
            }

        //user input is valid
            else -> return user(firstName, lastName, email, password, dob)
        }
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.register_save -> {
                var newUser = validateUserInput()
                if (newUser != null) {

                    //Save in preference
                    //Todo:startActivity Home after register and main preference isLogin verified
                    mainPrefs.firstname = newUser.firstName
                    mainPrefs.lastname = newUser.lastName
                    mainPrefs.email = newUser.email
                    mainPrefs.dob = newUser.dob
                    mainPrefs.password = newUser.password
                    mainPrefs.isLogged = true

                    val account = Account(newUser.email, "user")
                    val accountManager = AccountManager.get(applicationContext)
                    accountManager.addAccountExplicitly(account, newUser.password, null)

                    //Todo : implement for Firebase.

                }


            }
        }
        return super.onOptionsItemSelected(item)
    }


}


