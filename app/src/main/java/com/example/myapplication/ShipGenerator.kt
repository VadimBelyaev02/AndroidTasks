package com.example.myapplication

import android.content.Context
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlin.random.Random
import kotlinx.coroutines.launch



class ShipGenerator(private val label: TextView) {
    private val shipTypes = arrayListOf(ShipType.BANANA, ShipType.BREAD, ShipType.CLOTHES)
    private val shipCapacities = arrayListOf(10, 50, 100)
    private val tunnel = Tunnel(label)
    private var numberOfGeneratedShips: Long = 0
    private val coroutineScope = CoroutineScope(Dispatchers.Default)
    private val dock = Dock(label)

    suspend fun generateShip(label: TextView) {
        val ship = Ship(numberOfGeneratedShips++, shipTypes[Random.nextInt(shipTypes.size)], shipCapacities[Random.nextInt(shipCapacities.size)])

        val deferred = coroutineScope.async {
            val res = tunnel.goThroughTunnel(ship)
            res
        }

        val newShip = deferred.await()
        dock.loadShip(newShip)

    }
}