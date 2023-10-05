package com.example.myapplication.model

class Bike(id: Int, speed: Int, probabilityOfPuncturedWheel: Double, private val hasSidecar: Boolean) : Vehicle(id, speed, probabilityOfPuncturedWheel)  {

    override fun toString(): String {
        return "Vehicle with id: ${this.id}, speed: ${this.speed}, probability: ${this.probabilityOfPuncturedWheel}, type: Bike, has sidecar: $hasSidecar ."
    }
}