package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class Counter : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var counterView: CounterView
    private lateinit var counterTextView: TextView
    private val updateCounterLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data = result.data
                val newValue = data?.getIntExtra("newValue", 0) ?: 0
                counterView.value = newValue
                counterTextView.text = "$newValue"
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)

        button = findViewById(R.id.counterButton)
        counterView = findViewById(R.id.counterView)
        counterTextView = findViewById(R.id.counterTextView)
        counterView.value = 0

        button.setOnClickListener {
            val intent = Intent(this, UpdateCounter::class.java)
            intent.putExtra("currentValue", counterView.value)
            updateCounterLauncher.launch(intent)
        }
    }
}