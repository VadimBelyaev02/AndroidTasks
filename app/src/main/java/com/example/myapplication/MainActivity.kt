package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var bottomNavigation = findViewById<BottomNavigationView>(R.id.mainBottomNavigation)

        bottomNavigation.setOnItemSelectedListener { item ->
            val intentClass = when (item.itemId) {
                R.id.first -> FirstScreen::class.java
                R.id.second -> SecondScreen::class.java
                R.id.third -> ThirdScreen::class.java
                R.id.fourth -> FourthScreen::class.java
                R.id.fifth -> FifthScreen::class.java
                else -> null
            }

            intentClass?.let { startActivity(Intent(this, it)) }

            return@setOnItemSelectedListener intentClass != null
        }
    }
}