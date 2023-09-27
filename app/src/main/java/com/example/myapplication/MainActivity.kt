package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    //    private lateinit var progressBar: ProgressBar
//    private lateinit var updateButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        var intent: Intent? = null

        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.first -> {
                    intent = Intent(this, FirstScreen::class.java)
                    startActivity(intent)
                    return@setOnItemSelectedListener true
                }

                R.id.second -> {
                    intent = Intent(this, SecondScreen::class.java)
                    startActivity(intent)
                    return@setOnItemSelectedListener true
                }
                R.id.third -> {
                    intent = Intent(this, ThirdScreen::class.java)
                    startActivity(intent)
                    return@setOnItemSelectedListener true
                }
            }
            false
        }


    }
}