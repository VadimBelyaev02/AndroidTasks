package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.view.ViewTreeObserver
import android.widget.Button
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.appcompat.widget.Toolbar
import androidx.compose.ui.graphics.Color

class SecondScreenActivity : BaseScreenActivity() {

    private lateinit var containerLayout: FrameLayout
    private var maxViewsPerLine: Int = 3
    private var maxViewsPerColumn: Int = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)

        toolbar = findViewById(R.id.secondActivityToolbar)
        toolbar.title = getString(R.string.secondScreenToolbarText)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        leftButton = findViewById(R.id.leftButton)
        rightButton = findViewById(R.id.rightButton)
        containerLayout = findViewById(R.id.containerLayout)

        leftButton.text = getString(R.string.secondScreenLeftButtonText)
        rightButton.text = getString(R.string.secondScreenRightButtonText);

        leftButton.setOnClickListener {
            addView()
        }
        rightButton.setOnClickListener {
            removeView()
        }
    }

    private fun addView() {
        val viewWidth = resources.getDimensionPixelSize(R.dimen.view_width)
        val viewHeight = resources.getDimensionPixelSize(R.dimen.view_height)
        val layoutParams = LinearLayout.LayoutParams(
            viewWidth,
            viewHeight
        )

        val view = View(this)
        view.setBackgroundColor(0xFF00FF00.toInt());
        view.layoutParams = layoutParams

        val amountOfViews = containerLayout.childCount
        val row = amountOfViews / maxViewsPerLine
        val column = amountOfViews % maxViewsPerLine

        if (amountOfViews < maxViewsPerLine * maxViewsPerColumn) {
            layoutParams.leftMargin = column * viewWidth
            layoutParams.topMargin = row * viewHeight

            containerLayout.addView(view)
        }
    }

    private fun removeView() {
        if (containerLayout.childCount > 0) {
            containerLayout.removeViewAt(containerLayout.childCount - 1)
        }
    }
}