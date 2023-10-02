package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Util.UserGenerator
import com.example.myapplication.adapter.SecondScreenAdapter
import com.example.myapplication.model.User

class SecondScreen : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    private lateinit var people: List<User>;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)

        val toolbar = findViewById<Toolbar>(R.id.secondActivityToolbar)
        toolbar.title = getString(R.string.secondScreenToolbarText)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }


        var userGenerator = UserGenerator()
        people = arrayListOf()
        for (i in 1..30) {
            people += userGenerator.generateUser()
        }

        val adapter = SecondScreenAdapter(this, people)
        recyclerView = findViewById(R.id.users)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

    }
}