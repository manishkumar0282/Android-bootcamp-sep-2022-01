package com.programmingwithmanish.favoriteplaces

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var tvNoData: TextView? = null
    private var btnAddPlace: Button? = null
    private var rvPlacesList: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        tvNoData = findViewById(R.id.tv_no_data)
        rvPlacesList = findViewById(R.id.rv_places_list)
//        btnAddPlace = findViewById(R.id.btn_add_place)
//
//        btnAddPlace?.setOnClickListener {
//            val intent = Intent(this, AddPlace::class.java)
//            startActivity(intent)
//        }
    }
}