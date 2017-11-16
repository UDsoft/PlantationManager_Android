package com.udsoft.plantationmanager.Fragments.Date

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.DialogFragment
import android.os.Bundle
import java.util.*


/**
 * Created by darwin on 11/16/17.
 */
class DatePickerHandler : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calender = Calendar.getInstance()
        var year: Int = calender.get(Calendar.YEAR)
        var month: Int = calender.get(Calendar.MONTH)
        var date: Int = calender.get(Calendar.DAY_OF_MONTH)
        var dateSetting = DateSettings(activity.applicationContext)
        val dpd = DatePickerDialog(activity.applicationContext, dateSetting, year, month, date)
        return super.onCreateDialog(savedInstanceState)
    }
}