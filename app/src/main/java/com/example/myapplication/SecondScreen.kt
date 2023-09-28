package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar

class SecondScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)

//
        val toolbar = findViewById<Toolbar>(R.id.secondActivityToolbar)
        toolbar.title = getString(R.string.secondScreenToolbarText)
        setSupportActionBar(toolbar)
    }
}