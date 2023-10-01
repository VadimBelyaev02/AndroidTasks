package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView

class FifthScreen : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth_screen)
        val toolbar = findViewById<Toolbar>(R.id.fourthActivityToolbar)
        toolbar.title = getString(R.string.fourthScreenToolbarText)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }


        recyclerView = findViewById(R.id.fifthRecyclerView)
        progressBar = findViewById(R.id.progressBar)

        recyclerView.visibility = View.GONE
        progressBar.visibility = View.VISIBLE

        Handler().postDelayed({
            runOnUiThread {
                recyclerView.visibility = View.VISIBLE
                progressBar.visibility = View.GONE
            }
        }, 6000)
    }
}