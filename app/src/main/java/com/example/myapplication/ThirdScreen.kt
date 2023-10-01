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
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Util.CardGenerator
import com.example.myapplication.data.Card
import com.example.myapplication.data.CardListAdapter
import com.example.myapplication.data.UserListAdapter

class ThirdScreen : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    private val elementsAmount = 20


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

//        val adapter = UserListAdapter(this, people)
//        recyclerView = findViewById(R.id.users)
//        recyclerView.adapter = adapter
//        recyclerView.layoutManager = LinearLayoutManager(this)

        val cards = arrayListOf<Card>()
        val cardGenerator = CardGenerator()
        for (i in 1..elementsAmount) {
            cards += cardGenerator.generateCard(i)
        }
        val adapter = CardListAdapter(cards)
        recyclerView = findViewById(R.id.cardRecyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this, 2)


//        val gridLayout = findViewById<GridLayout>(R.id.table)
//        var inflater = LayoutInflater.from(this)
//        for (i in 1..elementsAmount) {
//
//            val cardView = inflater.inflate(R.layout.table_card, null) as CardView
//            val cardViewParams = GridLayout.LayoutParams()
//            // cardViewParams.width = resources.getDimensionPixelSize(R.dimen.cardWidth)
//            cardViewParams.width = 0
//            cardViewParams.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
//
//            cardViewParams.height = resources.getDimensionPixelSize(R.dimen.cardHeight)
//            val cardMargin = resources.getDimensionPixelSize(R.dimen.cardMargin)
//            cardViewParams.setMargins(cardMargin, cardMargin, cardMargin, cardMargin)
//
//            cardView.layoutParams = cardViewParams
//            val textView = cardView.findViewById<TextView>(R.id.cardTextView)
//            textView.text = texts[i % arraySize]
//
//            val imageView = cardView.findViewById<ImageView>(R.id.cardImageView)
//            imageView.setImageResource(icons[gridLayout.childCount % arraySize])
//
//
//            gridLayout.addView(cardView)
//
//        }
    }
}