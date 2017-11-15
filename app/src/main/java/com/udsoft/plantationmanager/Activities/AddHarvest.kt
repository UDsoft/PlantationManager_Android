package com.udsoft.plantationmanager.Activities

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.udsoft.plantationmanager.R
import kotlinx.android.synthetic.main.activity_add_harvest.*
import kotlinx.android.synthetic.main.general_toolbar.*

class AddHarvest : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_harvest)
        //Code haven't tested as the toolbar is basically from the include tag in the xml.
        general_toolbar.setTitleTextColor(Color.WHITE)
        setSupportActionBar(general_toolbar)

    }
}
