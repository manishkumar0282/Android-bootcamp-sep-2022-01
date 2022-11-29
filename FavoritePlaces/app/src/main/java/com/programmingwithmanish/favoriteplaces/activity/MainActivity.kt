package com.programmingwithmanish.favoriteplaces.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.programmingwithmanish.favoriteplaces.R
import com.programmingwithmanish.favoriteplaces.Store.PlacesStore

class MainActivity : AppCompatActivity() {

    private var tvNoData: TextView? = null
    private var btnAddPlace: FloatingActionButton? = null
    private var rvPlacesList: RecyclerView? = null

    override fun onResume() {
        super.onResume()
        if(PlacesStore.getPlaces().size > 0) {
            tvNoData?.visibility = View.GONE
            rvPlacesList?.visibility = View.VISIBLE
        } else {
            rvPlacesList?.visibility = View.GONE
            tvNoData?.visibility = View.VISIBLE
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        tvNoData = findViewById(R.id.tv_no_data)
        rvPlacesList = findViewById(R.id.rv_places_list)
        btnAddPlace = findViewById(R.id.btn_add_place)

        setAdapterForRecyclerView()
        btnAddPlace?.setOnClickListener {
            val intent = Intent(this, AddPlace::class.java)
            startActivity(intent)
        }
    }

    private fun setAdapterForRecyclerView() {

    }
}