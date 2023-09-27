package com.example.myapplication.Util

import com.example.myapplication.data.User
import com.example.myapplication.data.enums.Sex
import kotlin.random.Random

class UserGenerator {
    private val firstNames = listOf("John", "Jane", "Robert", "Emily", "Michael", "Olivia")
    private val lastNames = listOf("Smith", "Johnson", "Brown", "Davis", "Wilson", "Lee")

    fun generateUser(): User {
        val firstName = firstNames.random()
        val lastName = lastNames.random()
        val age = Random.nextInt(18, 65)
        val sex = if (Random.nextBoolean()) Sex.MALE else Sex.FEMALE
        val squareAvatarUrl = "https://image.cnbcfm.com/api/v1/image/105773423-1551716977818rtx6p9yw.jpg"
        val description = List(Random.nextInt(1, 5)) { generateRandomDescription() }
        return User(firstName, lastName, age, sex, squareAvatarUrl, description)
    }

    private fun generateRandomDescription(): String {
        val sentences = listOf(
            "Lorem ipsum dolor sit amet.",
            "Consectetur adipiscing elit.",
            "Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
            "Ut enim ad minim veniam.",
            "Quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
        )
        return sentences.shuffled().take(Random.nextInt(1, 4)).joinToString(" ")
    }
}