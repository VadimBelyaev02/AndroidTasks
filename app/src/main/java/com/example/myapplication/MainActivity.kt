package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var label: TextView
        private val coroutineScope = CoroutineScope(Dispatchers.Default)
    private lateinit var shipGenerator: ShipGenerator


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        label = findViewById(R.id.label)
        shipGenerator = ShipGenerator(label)

        Thread.sleep(5000)
        val numberOfShips = 100
        for (i in 1..numberOfShips) {
            coroutineScope.launch {
                shipGenerator.generateShip(label)
            }
        }
    }

}