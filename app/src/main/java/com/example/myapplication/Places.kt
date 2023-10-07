package com.example.myapplication

import Venue
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Places : AppCompatActivity() {

    private val connector = Connector()
    private lateinit var connectionButton: Button
    private lateinit var adapter: PlacesAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_places)

        connectionButton = findViewById(R.id.connectionButton)
        val places = findViewById<ConstraintLayout>(R.id.placesLayout)
        progressBar = findViewById(R.id.placesProgressBar)

        connectionButton.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            connectionButton.visibility = View.GONE
            places.visibility = View.VISIBLE

            CoroutineScope(Dispatchers.Main).launch {
                val venues = async(Dispatchers.IO) {
                    connector.connect()
                }.await()

                progressBar.visibility = View.GONE

                adapter = PlacesAdapter(venues)
                recyclerView = findViewById(R.id.placesList)
                recyclerView.adapter = adapter
                recyclerView.layoutManager = LinearLayoutManager(this@Places)
            }
        }
    }
}