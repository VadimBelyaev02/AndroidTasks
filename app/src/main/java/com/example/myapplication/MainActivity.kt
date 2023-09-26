package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val yellowView = findViewById<View>(R.id.yellowView)
        val redView = findViewById<View>(R.id.redView)
        val blueView = findViewById<View>(R.id.blueView)

        redView.bringToFront()


        val screenHeight = resources.displayMetrics.heightPixels.toFloat()
        val screenWidth = resources.displayMetrics.widthPixels.toFloat()

        val yellowParams = yellowView.layoutParams as LinearLayout.LayoutParams
        yellowParams.height = (screenHeight * 0.5).toInt()
        yellowParams.width = (screenWidth * 0.2).toInt()
        yellowView.layoutParams = yellowParams

        val redParams = redView.layoutParams as LinearLayout.LayoutParams
        redParams.height = (screenHeight * 0.85).toInt()
        redParams.width = (screenWidth * 0.55).toInt()
        redView.layoutParams = redParams

        val blueParams = blueView.layoutParams as LinearLayout.LayoutParams
        blueParams.height = (screenHeight * 0.8).toInt()
        blueParams.width = (screenWidth * 0.25).toInt()
        blueView.layoutParams = blueParams
    }
}