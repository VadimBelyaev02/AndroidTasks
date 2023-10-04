package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.widget.TextView
import kotlinx.coroutines.delay
import kotlinx.coroutines.sync.Semaphore
import java.util.LinkedList
import java.util.Queue

class Tunnel(private val context: Context) {
    private val semaphore = Semaphore(5)

    private var ships = arrayListOf<Ship>()
    suspend fun goThroughTunnel(ship: Ship, label: TextView): Ship {
        print("Ship with id = ${ship.id} try to enter the tunnel. ")
        println()



        semaphore.acquire()
        ships.remove(ship)
        println("Ship with id = ${ship.id} entered the tunnel")
        label.text = (label.text.toString() + "\nShip with id = ${ship.id} entered the tunnel")

        delay(4000)
        println("Ship with id = ${ship.id} left the tunnel")
        semaphore.release()
        label.text = (label.text.toString() + "\nShip with id = ${ship.id} left the tunnel")

        return ship
    }

    fun printInLabel(label: TextView) {
        (label.context as Activity).runOnUiThread {
           label.text = label.text.toString() + "\nShip with id = ${ship.id} try to enter the tunnel"
        }
    }
}