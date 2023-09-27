package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {

//    private lateinit var progressBar: ProgressBar
//    private lateinit var updateButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        var intent: Intent? = null

        bottomNavigation.setOnItemSelectedListener {item ->
            when(item.itemId) {
                R.id.favorite -> {
                    intent = Intent(this, FirstScreen::class.java)
                    startActivity(intent)
                    return@setOnItemSelectedListener true
                }
            }
            false
        }


        }
    }
/*
      var intent: Intent? = null
        when (view.id) {
            R.id.firstScreenButton -> {
                intent = Intent(this, FirstScreenActivity::class.java)
            }
            R.id.secondScreenButton -> {
                intent = Intent(this, SecondScreenActivity::class.java)
            }
            R.id.thirdScreenButton -> {
                intent = Intent(this, ThirdScreenActivity::class.java)
            }
        }
        if (intent != null) {
            startActivity(intent)
        }
 */
