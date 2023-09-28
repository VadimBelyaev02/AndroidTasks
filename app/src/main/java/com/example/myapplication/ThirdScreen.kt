package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.compose.ui.graphics.Color

class ThirdScreen : AppCompatActivity() {

    private var texts = arrayOf(
        "MY DOCTOR",
        "MY CAREMANAGER",
        "MY DIAGNOSIS",
        "THERAPY PLAN",
        "REMAINING PILLS",
        "MY ORDERS"
    )
    private var colors = arrayOf(
        Color(226, 253, 255),
        Color(87, 206, 249),
        Color(12, 156, 252),
        Color(4, 10, 94),
        Color(236, 239, 71),
        Color(242, 125, 29)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_screen)

        val toolbar = findViewById<Toolbar>(R.id.thirdActivityToolbar)
        toolbar.title = getString(R.string.thirdScreenToolbarText)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
}