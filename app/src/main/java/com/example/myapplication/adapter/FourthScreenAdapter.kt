package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class FourthScreenAdapter(private val numberOfElements : Int) :
    RecyclerView.Adapter<FourthScreenAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val cardView = LayoutInflater.from(parent.context).inflate(R.layout.four_screen_list_item, parent, false)
        return ViewHolder(cardView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (position % 3) {
            0 -> holder.leftSquare.visibility = View.GONE
            1 -> holder.rightSquare.visibility = View.GONE.also { holder.leftSquare.visibility = View.GONE }
            2 -> holder.rightSquare.visibility = View.GONE
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val leftSquare: View = itemView.findViewById(R.id.leftSquare)
        val rightSquare: View = itemView.findViewById(R.id.rightSquare)
    }


    override fun getItemCount(): Int {
        return numberOfElements
    }
}