package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class Counter : AppCompatActivity() {

    private var pauseStartTime: Long = 0
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

        val savedValue = savedInstanceState?.getInt("counterValue", 0) ?:0

        counterView.value = savedValue
        counterTextView.text = savedValue.toString()


        button.setOnClickListener {
            val intent = Intent(this, UpdateCounter::class.java)
            intent.putExtra("currentValue", counterView.value)
            updateCounterLauncher.launch(intent)
        }
    }

    override fun onStop() {
        super.onStop()
        changeBy(5)
        pauseStartTime = System.currentTimeMillis()
    }

    override fun onStart() {
        super.onStart()
        if (pauseStartTime != 0.toLong()) {
            val currentTime = System.currentTimeMillis()
            val minutesInBackground = ((currentTime - pauseStartTime) / 1000 / 60).toInt()
            changeBy(2 * (1 - minutesInBackground))
        }
    }

    private fun changeBy(diff: Int) {
        var currentValue = counterView.value
        currentValue += diff
        this.counterTextView.text = "$currentValue"
        counterView.value = currentValue
    }

    override fun onDestroy() {
        super.onDestroy()
        val sharedPreferences = getSharedPreferences("storage", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt("textCounter", counterView.value)
        editor.apply()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.run {
            putInt("counterValue", counterView.value)
        }
    }
}