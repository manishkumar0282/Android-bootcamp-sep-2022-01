package com.programmingwithmanish.favoriteplaces.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.programmingwithmanish.favoriteplaces.R
import com.programmingwithmanish.favoriteplaces.Store.PlacesStore
import com.programmingwithmanish.favoriteplaces.adapter.FavPlacesAdapter
import com.programmingwithmanish.favoriteplaces.model.FavPlaceModel

interface CellClickListener {
    fun onClick(model: FavPlaceModel)
}

class MainActivity : AppCompatActivity(), CellClickListener {

    private var tvNoData: TextView? = null
    private var btnAddPlace: FloatingActionButton? = null
    private var rvPlacesList: RecyclerView? = null

    override fun onResume() {
        super.onResume()
        rvPlacesList?.adapter?.notifyDataSetChanged()

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
            // send allow editing as true for add places
            // sending it false will
            // 1. disable the submit
            // 2. disable the edit text for title & address
            intent.putExtra("ALLOW_EDITING", false)
            startActivity(intent)
        }
    }

    private fun setAdapterForRecyclerView() {
        rvPlacesList?.adapter = FavPlacesAdapter(this, PlacesStore.getPlaces(), this)
        rvPlacesList?.layoutManager = LinearLayoutManager(this)
        rvPlacesList?.setHasFixedSize(true)
    }

    override fun onClick(model: FavPlaceModel) {

        val intent = Intent(this, AddPlace::class.java)
        // send allow editing as true for add places
        // sending it false will
        // 1. disable the submit
        // 2. disable the edit text for title & address
        intent.putExtra("ALLOW_EDITING", true)
        intent.putExtra("TITLE", model.title)
        intent.putExtra("ADDRESS", model.address)
        startActivity(intent)
    }
}
