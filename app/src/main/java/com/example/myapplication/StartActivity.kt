package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class StartActivity : AppCompatActivity() {

    //fsq3eOIQZVztuFwQXqCe8Udfvz1jsBWY8g3hRa3NinqX+PU=
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_activity)
    }

    override fun onResume() {
        super.onResume()
        Handler().postDelayed({
            val intent = Intent(this, Places::class.java)
            startActivity(intent)
            finish()
        }, resources.getInteger(R.integer.splash_screen_duration).toLong())

    }
}