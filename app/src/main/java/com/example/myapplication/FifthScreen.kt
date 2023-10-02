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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.myapplication.Util.UserGenerator
import com.example.myapplication.data.FifthScreenAdapter
import com.example.myapplication.data.User
import com.example.myapplication.data.UserListAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FifthScreen : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var adapter: FifthScreenAdapter
    private lateinit var people: List<User>
    private lateinit var userGenerator: UserGenerator

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

        userGenerator = UserGenerator()

        generateUsers()
        adapter = FifthScreenAdapter(this, people)
        recyclerView = findViewById(R.id.fifthRecyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        progressBar = findViewById(R.id.progressBar)

        val swipeRefreshLayout = findViewById<SwipeRefreshLayout>(R.id.swipeRefreshLayout)

        recyclerView.visibility = View.GONE
        progressBar.visibility = View.VISIBLE

        Handler().postDelayed({
            runOnUiThread {
                recyclerView.visibility = View.VISIBLE
                progressBar.visibility = View.GONE
            }
        }, 6000)

        var bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        var emptyView = findViewById<TextView>(R.id.emptyView)

        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.clearList -> {
                    adapter.clear()
                    emptyView.visibility = View.VISIBLE
                    true
                }
                else -> false
            }
        }

        swipeRefreshLayout.setOnRefreshListener {
            CoroutineScope(Dispatchers.Main).launch {
                delay(3000)
                generateUsers()
                adapter.update(people)
                swipeRefreshLayout.isRefreshing = false
                emptyView.visibility = View.INVISIBLE
            }
        }
    }


    private fun generateUsers() {
        people = arrayListOf()
        for (i in 1..30) {
            people += userGenerator.generateUser()
        }
    }

}