package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.widget.TextView
import kotlinx.coroutines.delay
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class Dock(private val label: TextView) {
    private val breadMutex = Mutex()
    private val bananaMutex = Mutex()
    private val clothesMutex = Mutex()

    suspend fun loadShip(ship: Ship) {
        println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAa")
        when (ship.type) {
            ShipType.BREAD -> {
                breadMutex.withLock {
                    loadCargo(ship)
                }
            }

            ShipType.CLOTHES -> {
                clothesMutex.withLock {
                    loadCargo(ship)
                }
            }

            ShipType.BANANA -> {
                bananaMutex.withLock {
                    loadCargo(ship)
                }
            }
        }
    }

    private suspend fun loadCargo(ship: Ship) {
        println("BBBBBBBBBBBBBBBBBBB")
        println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD" + ship.capacity)
        var capacity = ship.capacity
        while (capacity > 0) {
            capacity -= 10
            delay(1000   )
        }
        println("CCCCCCCCCCCCCCCCCCCCCCCCCCC")

        (label.context as Activity).runOnUiThread {
            label.text = label.text.toString() + "\nShip ${ship.id} (${ship.type}, ${ship.capacity})  is loaded"
        }

    }
}