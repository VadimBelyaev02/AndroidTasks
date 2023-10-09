package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class VenueActivity : AppCompatActivity() {

    private val labels = arrayOf(
        "BEENHERE",
        "CATEGORIES",
        "CONTACT",
        "HASPERK",
        "HERENOW",
        "ID",
        "LOCATION",
        "NAME"
    )

    private lateinit var layout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_venue)

        layout = findViewById(R.id.venueDetails)
        setLabels()

    }

    private fun setLabels() {
        for (label in labels) {
            val inflater = LayoutInflater.from(this)
            val textViewLabel = inflater.inflate(R.layout.venue_details_label, null )
            textViewLabel.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            textViewLabel.text = label
            textViewLabel.setTextAppearance( R.style.Venue_Label)

            layout.addView(textViewLabel)
        }
    }
}