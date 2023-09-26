package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar

class FirstScreenActivity : BaseScreenActivity() {

    private lateinit var leftButton: Button
    private lateinit var rightButton: Button
    private lateinit var bearPicture: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_screen)

        val toolbar: Toolbar = findViewById(R.id.firstActivityToolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        bearPicture = findViewById(R.id.bearPicture)
        leftButton = findViewById(R.id.leftButton)
        rightButton = findViewById(R.id.rightButton)

        leftButton.text = "Hide"
        rightButton.text = "Show";

        leftButton.setOnClickListener {
            bearPicture.visibility = View.INVISIBLE
        }
        rightButton.setOnClickListener {
            bearPicture.visibility = View.VISIBLE
        }
    }

}