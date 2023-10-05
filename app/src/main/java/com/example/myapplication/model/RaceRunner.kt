package com.example.myapplication.model

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import kotlin.random.Random

class RaceRunner(private val vehicles: List<Vehicle>, private val trackLength: Int) {

    private val executorService: ExecutorService = Executors.newFixedThreadPool(5)
    fun race() {
        val threads = mutableListOf<Thread>()

        for (vehicle in vehicles) {
            val thread = Thread {
                run(vehicle)
            }
            threads += thread
        }

        startRaceAndWait(threads)

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
            println("$vehicle has covered $distance out of $trackLength")
        }
    }

    private fun startRaceAndWait(threads: List<Thread>) {
        for (thread in threads) {
            thread.start()
        }

        for (thread in threads) {
            thread.join()
        }
    }

    private fun printResults() {
        val sortedVehicles = vehicles.sortedBy { vehicle: Vehicle -> vehicle.speed }
        println("Race results: ")
        for (i in sortedVehicles.indices) {
            println("${i}) ${sortedVehicles[i]}")
        }
    }
}