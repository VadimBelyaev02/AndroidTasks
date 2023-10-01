package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Util.CardGenerator
import com.example.myapplication.data.Card
import com.example.myapplication.data.CardListAdapter
import com.example.myapplication.data.FourthScreenAdapter

class FourthActivityScreen : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    private val elementsAmount = 20
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth_screen)
        val toolbar = findViewById<Toolbar>(R.id.fourthActivityToolbar)
        toolbar.title = getString(R.string.fourthScreenToolbarText)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }


        val adapter = FourthScreenAdapter(elementsAmount)
        recyclerView = findViewById(R.id.fourthScreenRecycler)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}