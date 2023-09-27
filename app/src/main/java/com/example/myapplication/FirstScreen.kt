package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Util.UserGenerator
import com.example.myapplication.data.User
import com.example.myapplication.data.UserListAdapter

class FirstScreen : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    private lateinit var people: List<User>;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_screen)

        var userGenerator = UserGenerator()
        for (i in 1..30) {
            people += userGenerator.generateUser()
        }

        val adapter = UserListAdapter(people)
        recyclerView = findViewById(R.id.users)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

    }
}