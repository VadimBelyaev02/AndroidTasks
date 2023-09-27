package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb

class MainActivity : AppCompatActivity() {

    private val colors = arrayOf(Color.Black, Color.Blue, Color.Cyan, Color.Yellow, Color.Green,
        Color.Red, Color.Magenta, Color.LightGray,
        Color(79,3,0), Color(135, 0, 142))

    private lateinit var view: View
    private lateinit var indexText: TextView
    private var currentIndex = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        indexText = findViewById(R.id.currentIndexText)
        val previousButton = findViewById<Button>(R.id.previousButton)
        val nextButton = findViewById<Button>(R.id.nextButton)
        view = findViewById(R.id.customView)
        view.setBackgroundColor(colors[currentIndex].toArgb())

        indexText.text = currentIndex.toString()



        previousButton.setOnClickListener {
            previousColor()
        }
        nextButton.setOnClickListener {
            nextColor()
        }
    }

    private fun previousColor() {
        currentIndex--
        if (currentIndex < 0) {
            currentIndex = 9;
        }
        view.setBackgroundColor(colors[currentIndex].toArgb())
        indexText.text = currentIndex.toString()
    }

    private fun nextColor() {
        currentIndex++
        if (currentIndex > 9) {
            currentIndex = 0
        }
        view.setBackgroundColor(colors[currentIndex].toArgb())
        indexText.text = currentIndex.toString()
    }
}