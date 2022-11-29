package com.programmingwithmanish.favoriteplaces.Store

import com.programmingwithmanish.favoriteplaces.model.FavPlaceModel

object PlacesStore {
    private var places: ArrayList<FavPlaceModel> = ArrayList<FavPlaceModel>();
    private var lastIndex: Int = 0
    fun getPlaces(): ArrayList<FavPlaceModel> {
        return places
    }

    fun addPlace(title: String, address: String ) {
        // 1, home, delhi
        // 2, colg, chandigarh
        // 3, dadu house, shimla
        //
        val newItem = FavPlaceModel(++lastIndex, title, address)
        places.add(newItem)
    }
}