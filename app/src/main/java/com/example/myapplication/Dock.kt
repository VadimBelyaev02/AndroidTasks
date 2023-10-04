package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.widget.TextView
import kotlinx.coroutines.delay
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class Dock(private val context: Context) {
    private val breadMutex = Mutex()
    private val bananaMutex = Mutex()
    private val clothesMutex = Mutex()

    suspend fun loadShip(ship: Ship, label: TextView) {
        println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAa")
        when (ship.type) {
            ShipType.BREAD -> {
                breadMutex.withLock {
                    loadCargo(ship, label)
                }
            }

            ShipType.CLOTHES -> {
                clothesMutex.withLock {
                    loadCargo(ship, label)
                }
            }

            ShipType.BANANA -> {
                bananaMutex.withLock {
                    loadCargo(ship, label)
                }
            }
        }
    }

    private suspend fun loadCargo(ship: Ship, label: TextView) {
        var capacity = ship.capacity
        while (ship.capacity > 0) {
            capacity -= 10
            delay(1000)
        }
        println("Ship with id = ${ship.id} was loaded")
        label.text = (label.text.toString() + "\nShip with id = ${ship.id} was loaded")

    }
}