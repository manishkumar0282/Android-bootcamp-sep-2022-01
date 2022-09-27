package com.programmingwithmanish.agetominutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private var tvSelectedDate: TextView? = null
    private var tvAgeInMinutes: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvSelectedDate = findViewById(R.id.selected_date)
        tvAgeInMinutes = findViewById(R.id.age_in_minutes)

        val btnSelectDate: Button = findViewById(R.id.btn_select_date)
        btnSelectDate.setOnClickListener {
            onSelectedDate()
        }
    }

    private fun onSelectedDate() {
        // get the current date
        val myCal = Calendar.getInstance()
        val cYear = myCal.get(Calendar.YEAR); // 2022
        val cMonth = myCal.get(Calendar.MONTH); // 9
        val cDays = myCal.get(Calendar.DAY_OF_MONTH); //27

        val dpd = DatePickerDialog(this,
        DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            Toast.makeText(this, "year - $year month - ${month+1} Day - $dayOfMonth", Toast.LENGTH_LONG).show()
            // Age = Current - DOB
            // In minutes
            // step 1: calculate the selected date "27/9/2022"
            val selectedDate = "$dayOfMonth/${month+1}/$year"
            // step 2: Show the selected date
            tvSelectedDate?.text = selectedDate

            // India 6/9
            // US 9/6
            val sdf = SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH)
            val bDate = sdf.parse(selectedDate)
            bDate?.let {
                val bDateInMin = bDate.time/60000

                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                currentDate?.let{
                    val currDateInMinutes = currentDate.time/60000
                    val ageInMinutes = currDateInMinutes - bDateInMin
                    tvAgeInMinutes?.text = ageInMinutes.toString()
                }
            }
        },
        cYear, cMonth, cDays)

        dpd.datePicker.maxDate = System.currentTimeMillis() - 86400000
        dpd.show()
    }
}