package com.udsoft.plantationmanager.Fragments.Date

import android.app.DatePickerDialog
import android.content.Context
import android.widget.DatePicker
import android.widget.Toast

/**
 * Created by darwin on 11/16/17.
 */
class DateSettings(var context: Context) : DatePickerDialog.OnDateSetListener {

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        Toast.makeText(context, "Harvest Date : $dayOfMonth/$month/$year", Toast.LENGTH_SHORT).show()
    }

}