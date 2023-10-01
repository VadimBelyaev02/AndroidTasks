package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.compose.ui.graphics.Color

class ThirdScreen : AppCompatActivity() {

    val elementsAmount = 20
    val arraySize = 6

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
        Color(4, 10, 94),
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_screen)

        val toolbar = findViewById<Toolbar>(R.id.thirdActivityToolbar)
        toolbar.title = getString(R.string.thirdScreenToolbarText)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        val gridLayout = findViewById<GridLayout>(R.id.table)
        var inflater = LayoutInflater.from(this)
        for (i in 1..elementsAmount) {

            val cardView = inflater.inflate(R.layout.table_card, null) as CardView
            val cardViewParams = GridLayout.LayoutParams()
           // cardViewParams.width = resources.getDimensionPixelSize(R.dimen.cardWidth)
                  cardViewParams.width = 0
            cardViewParams.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)

            cardViewParams.height = resources.getDimensionPixelSize(R.dimen.cardHeight)
            val cardMargin = resources.getDimensionPixelSize(R.dimen.cardMargin)
            cardViewParams.setMargins(cardMargin, cardMargin, cardMargin, cardMargin)

            cardView.layoutParams = cardViewParams
            val textView = cardView.findViewById<TextView>(R.id.cardTextView)
            textView.text = texts[i % arraySize]

            val imageView = cardView.findViewById<ImageView>(R.id.cardImageView)
            imageView.setImageResource(icons[gridLayout.childCount % arraySize])


            gridLayout.addView(cardView)

        }
    }
}