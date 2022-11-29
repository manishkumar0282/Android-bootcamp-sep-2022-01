package com.programmingwithmanish.favoriteplaces.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.programmingwithmanish.favoriteplaces.R
import com.programmingwithmanish.favoriteplaces.model.FavPlaceModel
import kotlinx.android.synthetic.main.item_fav_place.view.*

open class FavPlacesAdapter(
    private val context: Context,
    private var list: ArrayList<FavPlaceModel>
): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var onClickListener: View.OnClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(
            R.layout.item_fav_place, parent, false
        ))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = list[position]
        if(holder is MyViewHolder) {

            holder.itemView.tvTitle.text = model.title;
            holder.itemView.tvAddress.text = model.address;
        }
    }

    override fun getItemCount(): Int {
        return list.size;
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    interface OnClickListener : View.OnClickListener {
        fun onClick(position: Int, model: FavPlaceModel)
    }
}

class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

}
