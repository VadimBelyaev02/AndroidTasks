package com.example.myapplication.model

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future
import kotlin.random.Random

class RaceRunner(private val vehicles: List<Vehicle>, private val trackLength: Int) {

    private val executorService: ExecutorService = Executors.newFixedThreadPool(vehicles.size)
    fun race() {
        val futures = mutableListOf< Future<Unit>>()

        for (vehicle in vehicles) {
            val future = executorService.submit<Unit> {
                run(vehicle)
            }
            futures += future
        }

        for (future in futures) {
            future.get()
        }

        printResults()
    }

    private fun run(vehicle: Vehicle) {
        println("$vehicle")
        var distance = 0

        while (distance < trackLength) {
            if (Random.nextDouble() > vehicle.probabilityOfPuncturedWheel) {
                distance += vehicle.speed
                Thread.sleep(1000)
            } else {
                println("$vehicle broke a wheel")
                Thread.sleep(5000)
            }
            println("$vehicle has covered ${distance.coerceAtMost(trackLength)} out of $trackLength")
        }
    }


    private fun printResults() {
        val sortedVehicles = vehicles.sortedBy { vehicle: Vehicle -> vehicle.speed }.reversed()
        println("Race results: ")
        for (i in sortedVehicles.indices) {
            println("${i}) ${sortedVehicles[i]}")
        }
    }
}