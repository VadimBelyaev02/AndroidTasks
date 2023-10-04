package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.widget.TextView
import kotlinx.coroutines.delay
import kotlinx.coroutines.sync.Semaphore
import java.util.LinkedList
import java.util.Queue

class Tunnel(private val label: TextView) {
    private val semaphore = Semaphore(5)

    private var ships = arrayListOf<Ship>()
    suspend fun goThroughTunnel(ship: Ship): Ship {
        printInLabel("\nShip with id = ${ship.id} try to enter the tunnel")
        semaphore.acquire()
        ships.remove(ship)
        printInLabel("\nShip with id = ${ship.id} entered the tunnel")

        delay(4000)
        semaphore.release()
        printInLabel("\nShip with id = ${ship.id} left the tunnel")
        return ship
    }

    private fun printInLabel(text: String) {
        (label.context as Activity).runOnUiThread {
            label.text = label.text.toString() + text
        }
    }
}