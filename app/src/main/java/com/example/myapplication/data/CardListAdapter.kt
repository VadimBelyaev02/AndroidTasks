package com.example.myapplication.data

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.compose.ui.graphics.toArgb
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class CardListAdapter(private val cardList: List<Card>):
    RecyclerView.Adapter<CardListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardListAdapter.ViewHolder {
        val cardView = LayoutInflater.from(parent.context).inflate(R.layout.table_card, parent, false)
        return ViewHolder(cardView)
    }

    override fun getItemCount(): Int {
        return cardList.size
    }

    override fun onBindViewHolder(holder: CardListAdapter.ViewHolder, position: Int) {
        val item = cardList[position]

        holder.imageView.setImageResource(item.iconId)
        holder.cardView.setCardBackgroundColor(item.color.toArgb())
        holder.textView.text = item.text
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView: CardView = itemView.findViewById(R.id.tableCard)
        val imageView: ImageView = itemView.findViewById(R.id.cardImageView)
        val textView: TextView = itemView.findViewById(R.id.cardTextView)
    }
}