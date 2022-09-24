package com.programmingwithmanish.myapplication

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPicker : Button = findViewById(R.id.btn_show_picker)
        btnPicker.setOnClickListener{view ->
            onPickerClicked()
        }
    }
    
    fun onPickerClicked() {

        var calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener{view, year, month, dayOfMonth ->
            Toast.makeText(this, "Hello", Toast.LENGTH_LONG).show()
        },
    year,
    month,
    day).show()

    }
}