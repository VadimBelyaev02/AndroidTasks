package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class Places : AppCompatActivity() {

    private val connector = Connector(this)
    private lateinit var adapter: PlacesAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_places)

        progressBar = findViewById(R.id.placesProgressBar)
        recyclerView = findViewById(R.id.placesList)
        recyclerView.visibility = View.GONE
        progressBar.visibility = View.VISIBLE

        CoroutineScope(Dispatchers.Main).launch {
            val venues = async(Dispatchers.IO) {
                connector.connect()
            }.await()
            println(venues.size)
            for (element in venues) {
                println(element)
            }
            progressBar.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE

            adapter = PlacesAdapter(venues)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(this@Places)
        }
    }
}