package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    private lateinit var label: TextView
    private var toastTime = 0
    private var time = 0
    private val toastDelayMillis: Long = 10000
    private val handler = Handler(Looper.getMainLooper())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        label = findViewById(R.id.label)

        startChronometer()

    }

    private fun startChronometer() {
        Thread {
            while (true) {
                time++
                Thread.sleep(1000)
                handler.post {
                    label.text = time.toString()
                }
            }
        }.start()

        Thread {
            while (true) {
                toastTime++
                Thread.sleep(toastDelayMillis)
                if (toastTime % 4 != 0) {
                    handler.post {
                        Toast.makeText(this, time.toString(), Toast.LENGTH_LONG).show()
                    }
                }

            }
        }.start()

        Thread {
            while (true) {
                Thread.sleep(toastDelayMillis * 4)
                handler.post {
                    Toast.makeText(this, "Surprise", Toast.LENGTH_LONG).show()
                }
            }
        }.start()
    }

}