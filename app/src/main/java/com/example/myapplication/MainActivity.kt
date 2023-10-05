package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.myapplication.model.RaceRunner
import com.example.myapplication.model.Vehicle
import com.example.myapplication.model.VehicleType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var vehicles = mutableListOf<Vehicle>()
    private val vehicleFactory = VehicleFactory()
    private val vehicleTypes = arrayListOf(VehicleType.CAR, VehicleType.TRUCK, VehicleType.BIKE)
    private lateinit var raceRunner: RaceRunner
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)

        button.setOnClickListener {
            button.visibility = View.GONE
            val numberOfVehicles = 5
            for (i in 1..numberOfVehicles) {
                vehicles += vehicleFactory.createVehicle(vehicleTypes[Random.nextInt(3)])
            }

            raceRunner = RaceRunner(vehicles, Random.nextInt(200) + 100)
            raceRunner.race()
            button.visibility = View.VISIBLE
        }



    }
}