package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

abstract class BaseScreenActivity : AppCompatActivity() {

    protected lateinit var leftButton: Button
    protected lateinit var rightButton: Button
    protected lateinit var toolbar: Toolbar


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}