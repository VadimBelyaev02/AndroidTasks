package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Util.UserGenerator
import com.example.myapplication.data.FifthScreenAdapter
import com.example.myapplication.data.User
import com.example.myapplication.data.UserListAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView

class FifthScreen : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var adapter: FifthScreenAdapter
    private lateinit var people: List<User>
    private lateinit var emptyView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth_screen)
        val toolbar = findViewById<Toolbar>(R.id.fifthActivityToolbar)
        toolbar.title = getString(R.string.fifthScreenToolbarText)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        emptyView = findViewById(R.id.emptyView)
        var userGenerator = UserGenerator()
        people = arrayListOf()
        for (i in 1..30) {
            people += userGenerator.generateUser()
        }
        adapter = FifthScreenAdapter(this, people)
        recyclerView = findViewById(R.id.fifthRecyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        progressBar = findViewById(R.id.progressBar)

        recyclerView.visibility = View.GONE
        progressBar.visibility = View.VISIBLE

        var bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        var intent: Intent? = null

        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.first -> {
                    intent = Intent(this, FirstScreen::class.java)
                    startActivity(intent)
                    return@setOnItemSelectedListener true
                }

                R.id.second -> {
                    intent = Intent(this, SecondScreen::class.java)
                    startActivity(intent)
                    return@setOnItemSelectedListener true
                }
                R.id.third -> {
                    intent = Intent(this, ThirdScreen::class.java)
                    startActivity(intent)
                    return@setOnItemSelectedListener true
                }
                R.id.fourth -> {
                    intent = Intent(this, FourthScreen::class.java)
                    startActivity(intent)
                    return@setOnItemSelectedListener true
                }
                R.id.fifth -> {
                    intent = Intent(this, FifthScreen::class.java)
                    startActivity(intent)
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }
}