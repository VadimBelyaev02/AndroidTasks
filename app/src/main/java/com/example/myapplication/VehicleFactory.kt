package com.example.myapplication

import com.example.myapplication.model.Bike
import com.example.myapplication.model.Car
import com.example.myapplication.model.Truck
import com.example.myapplication.model.Vehicle
import com.example.myapplication.model.VehicleType
import kotlin.random.Random

class VehicleFactory {

    private var vehiclesCreated: Int = 0

    fun createVehicle(type: VehicleType): Vehicle {
        vehiclesCreated++
        val speed = (Random.nextInt(5) + 1) * 10
        val probability = Random.nextDouble(0.5) + 0.1
        return when (type) {
            VehicleType.BIKE -> return Bike(
                vehiclesCreated,
                speed,
                probability,
                Random.nextInt() == 1
            )

            VehicleType.CAR -> return Car(
                vehiclesCreated,
                speed,
                probability,
                Random.nextInt(5)
            )

            VehicleType.TRUCK -> return Truck(
                vehiclesCreated,
                speed,
                probability,
                Random.nextInt(10)
            )
        }
    }

    }