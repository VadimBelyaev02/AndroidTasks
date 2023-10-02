package com.example.myapplication.Util

import androidx.compose.ui.graphics.Color
import com.example.myapplication.R
import com.example.myapplication.model.Card

class CardGenerator {

    private val arraySize = 6

    private var texts = arrayOf(
        "MY DOCTOR",
        "MY CAREMANAGER",
        "MY DIAGNOSIS",
        "THERAPY PLAN",
        "REMAINING PILLS",
        "MY ORDERS"
    )
    private var colors = arrayOf(
        Color(226, 253, 255),
        Color(87, 206, 249),
        Color(12, 156, 252),
        Color(217, 59, 245),
        Color(236, 239, 71),
        Color(242, 125, 29)
    )

    private var icons = arrayOf(
        R.drawable.person_add_90,
        R.drawable.medication_90,
        R.drawable.fireplace_90,
        R.drawable.checklist_90,
        R.drawable.health_and_safety_90,
        R.drawable.catching_pokemon_90
    )
    fun generateCard(i: Int) : Card {
        val ind = i % arraySize
        val text: String = texts[ind]
        val iconId: Int = icons[ind]
        val color: Color = colors[ind]
        return Card(text, iconId, color)
    }
}