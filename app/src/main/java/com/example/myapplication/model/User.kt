package com.example.myapplication.model

import com.example.myapplication.model.enums.Sex

data class User(
    val firstName: String,
    val lastName: String,
    val age: Int,
    val sex: Sex,
    val squareAvatarUrl: String,
    val description: List<String>
)
