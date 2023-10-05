package com.example.myapplication.model

class Truck(id: Int, speed: Int, probabilityOfPuncturedWheel: Double, private val cargoWeight: Int) : Vehicle(id, speed, probabilityOfPuncturedWheel) {

    override fun toString(): String {
        return "Vehicle with id: ${this.id}, speed: ${this.speed}, probability: ${this.probabilityOfPuncturedWheel}, type: Truck, cargo weight: $cargoWeight ."
    }
}