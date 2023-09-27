package com.example.myapplication

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar

class ThirdScreenActivity : BaseScreenActivity() {
    private lateinit var leftButton: Button
    private lateinit var rightButton: Button
    private lateinit var bearPicture: ImageView
    private var alphaLevel = 1.0f;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_screen)

        val toolbar: Toolbar = findViewById(R.id.thirdActivityToolbar)
        toolbar.title = "Third Window"
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        bearPicture = findViewById(R.id.bearPicture)
        leftButton = findViewById(R.id.leftButton)
        rightButton = findViewById(R.id.rightButton)

        leftButton.text = "Increase alpha"
        rightButton.text = "Decrease alpha"

        leftButton.setOnClickListener {
            increaseAlpha()
        }
        rightButton.setOnClickListener {
            decreaseAlpha()
        }
    }


    private fun increaseAlpha() {
        if (alphaLevel < 1.0f) {
            alphaLevel += 0.1f
            applyAlphaAnimation()
        }
    }

    private fun decreaseAlpha() {
        if (alphaLevel > 0.0f) {
            alphaLevel -= 0.1f
            applyAlphaAnimation()
        }
    }

    private fun applyAlphaAnimation() {
        val anim = ObjectAnimator.ofFloat(bearPicture, "alpha", alphaLevel)
        anim.duration = 300
        anim.start()
    }

}