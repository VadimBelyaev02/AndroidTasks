package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openActivity(view: View) {
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
    }


}