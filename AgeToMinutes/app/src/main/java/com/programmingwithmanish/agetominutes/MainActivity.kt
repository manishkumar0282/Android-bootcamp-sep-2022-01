package com.programmingwithmanish.agetominutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSelectDate: Button = findViewById(R.id.btn_select_date)
        btnSelectDate.setOnClickListener{
            onSelectedDate()
        }
    }

    fun onSelectedDate() {
        val myCal = Calendar.getInstance()
        val cYear = myCal.get(Calendar.YEAR);
        val cMonth = myCal.get(Calendar.MONTH);
        val cDays = myCal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog(this,
        DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            Toast.makeText(this, cYear.toString(), Toast.LENGTH_LONG).show()

        },
        cYear, cMonth, cDays).show()
    }
}