package com.example.myapplication

import Venue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlacesAdapter(private val venues: List<Venue>):
    RecyclerView.Adapter<PlacesAdapter.ViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlacesAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.place_list_item, parent, false)
        return ViewHolder(itemView)
    }
    override fun getItemCount(): Int {
        return venues.size
    }

    override fun onBindViewHolder(holder: PlacesAdapter.ViewHolder, position: Int) {
        val item = venues[position]

        println(item.location.address)

        holder.address.text = item.location.address
        holder.venue.text = item.name

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
      //      val photo: ImageView = itemView.findViewById(R.id.photo)
        val venue: TextView = itemView.findViewById(R.id.venue)
        val address: TextView = itemView.findViewById(R.id.place)
    }
}