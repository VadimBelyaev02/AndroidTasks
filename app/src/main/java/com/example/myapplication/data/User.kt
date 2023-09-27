package com.example.myapplication.data

import com.example.myapplication.data.enums.Sex

data class User(
    val firstName: String,
    val lastName: String,
    val age: Int,
    val sex: Sex,
    val squareAvatarUrl: String,
    val description: List<String>
)
