package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ProgressBar
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var progress = 0
    private lateinit var progressBar: ProgressBar
    private lateinit var updateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        progressBar = findViewById(R.id.progressBar)
        updateButton = findViewById(R.id.updateButton)

        updateButton.setOnClickListener {
            progress += 10
            progressBar.progress = progress
            progressBar.max = 100
        }
    }
}