package com.udsoft.plantationmanager.Activities

import android.app.DatePickerDialog
import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.udsoft.plantationmanager.R
import kotlinx.android.synthetic.main.activity_add_harvest.*
import java.util.Calendar


class AddHarvest : AppCompatActivity() {

    //LOGGING
    val TAG = "addHarverst"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_harvest)
        //Code haven't tested as the toolbar is basically from the include tag in the xml.
        toolbar_new_harvest.setTitleTextColor(Color.WHITE)
        setSupportActionBar(toolbar_new_harvest)
        val harvestDateDialog = datePickerDialog()
        input_harverst_date.setOnClickListener { harvestDateDialog.show() }
        switch_harvest_transportation_expenses.setOnCheckedChangeListener { _, isChecked ->
            val inputExist = input_transportation_cost_box
            val labelExist = label_new_harverst_transportation_expenses
            if (isChecked) {
                inputExist.visibility = View.VISIBLE
                labelExist.visibility = View.INVISIBLE
            } else {
                inputExist.visibility = View.INVISIBLE
                labelExist.visibility = View.VISIBLE
            }
        }

        switch_harvest_labour_cost.setOnCheckedChangeListener { _, isChecked ->
            val inputExist = input_labour_cost_box
            val labelExist = label_harvest_labour_cost
            if (isChecked) {
                inputExist.visibility = View.VISIBLE
                labelExist.visibility = View.INVISIBLE
            } else {
                inputExist.visibility = View.INVISIBLE
                labelExist.visibility = View.VISIBLE
            }
        }

    }

    override fun onStart() {
        super.onStart()
        input_harverst_date.setText(harvestDate())
    }

    private fun harvestDate(harvestDate: Calendar = Calendar.getInstance(),
                            date: Int = harvestDate.get(Calendar.DATE),
                            month: Int = harvestDate.get(Calendar.MONTH),
                            year: Int = harvestDate.get(Calendar.YEAR)): String {

        val date: String = date.toString()
        //Since Using the Calender library the Month of January is 0
        //Thus to save the true value 1 is added to the Month of the Calender
        val month: String = (month + 1).toString()
        val year: String = year.toString()



        Log.i("function:harvestDate", "$date/$month/$year")

        return "$date/$month/$year"
    }

    fun datePickerDialog(): DatePickerDialog {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        // Date Picker Dialog
        val datePickerDialog = DatePickerDialog(this@AddHarvest, android.R.style.ThemeOverlay_Material_Dialog, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            // Display Selected date in display
            input_harverst_date.setText(harvestDate(date = dayOfMonth, month = monthOfYear, year = year))
        }, year, month, day)

        return datePickerDialog
    }


}
