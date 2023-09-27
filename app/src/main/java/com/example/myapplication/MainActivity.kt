package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    private lateinit var updateButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        progressBar = findViewById(R.id.progressBar)
        updateButton = findViewById(R.id.updateButton)

        updateButton.setOnClickListener {
            updateProgressBar()
        }
    }

    private fun updateProgressBar() {
        val randomProgress = Random.nextInt(1, 101)
        progressBar.animate().duration = 1000
        progressBar.setProgress(randomProgress, true)
    }
}