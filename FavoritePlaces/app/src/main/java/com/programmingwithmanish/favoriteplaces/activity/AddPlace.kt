package com.programmingwithmanish.favoriteplaces.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.programmingwithmanish.favoriteplaces.R
import com.programmingwithmanish.favoriteplaces.Store.PlacesStore

class AddPlace : AppCompatActivity() {
    var btnSubmit: Button? = null
    var tvTitle: TextView? = null
    var tvAddress: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_place)

        btnSubmit = findViewById(R.id.btn_submit)
        tvTitle = findViewById(R.id.tv_name)
        tvAddress = findViewById(R.id.tv_address)

        btnSubmit?.setOnClickListener{
            val title = tvTitle?.text.toString()
            val address = tvAddress?.text.toString()

            if(title.isNotEmpty() && address.isNotEmpty()) {
                PlacesStore.addPlace(title, address)
            }
            else {
                Toast.makeText(this, "Insufficient data, Place was not saved",
                    Toast.LENGTH_LONG).show()
            }
            finish()
        }
    }
}