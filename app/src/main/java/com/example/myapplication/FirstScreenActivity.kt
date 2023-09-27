package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class FirstScreenActivity : BaseScreenActivity() {

    private lateinit var leftButton: Button
    private lateinit var rightButton: Button
    private lateinit var bearPicture: ImageView
    private lateinit var hiddenText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_screen)

        val toolbar: Toolbar = findViewById(R.id.firstActivityToolbar)
        toolbar.title = getString(R.string.firstScreenToolbarText)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        bearPicture = findViewById(R.id.bearPicture)
        leftButton = findViewById(R.id.leftButton)
        rightButton = findViewById(R.id.rightButton)
        hiddenText = findViewById(R.id.hiddenText)

        hiddenText.visibility = View.INVISIBLE

        leftButton.text = getString(R.string.firstScreenLeftButtonText)
        rightButton.text = getString(R.string.firstScreenRightButtonText);

        leftButton.setOnClickListener {
            bearPicture.visibility = View.INVISIBLE
            hiddenText.visibility = View.VISIBLE

        }
        rightButton.setOnClickListener {
            bearPicture.visibility = View.VISIBLE
            hiddenText.visibility = View.INVISIBLE

        }
    }

}