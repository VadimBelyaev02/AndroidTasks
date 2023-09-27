package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
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

        val r = progressBar.rotation
        val currentProgress = progressBar.progress
        val newProgress = currentProgress + 10
        if (newProgress <= progressBar.max) {
            progressBar.progress = newProgress
            progressBar.rotation = r - 15
        }


//        val randomProgress = Random.nextInt(1, 101)
//        progressBar.animate().duration = 1000
//        progressBar.setProgress(randomProgress, true)
    }
}