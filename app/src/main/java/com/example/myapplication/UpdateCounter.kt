package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class UpdateCounter : AppCompatActivity() {
    private lateinit var cancelButton: Button
    private lateinit var updateButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_counter)

        cancelButton = findViewById(R.id.cancelButton)
        updateButton = findViewById(R.id.updateButton)

        cancelButton.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
        var currentValue = intent.getIntExtra("currentValue", 0)

        updateButton.setOnClickListener {
            currentValue += 10
            val resultIntent = Intent()
            resultIntent.putExtra("newValue", currentValue)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}