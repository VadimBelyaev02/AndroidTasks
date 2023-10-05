package com.example.myapplication.model

class Car(id: Int, speed: Int, probabilityOfPuncturedWheel: Double, private val passengersAmount: Int) :
    Vehicle(id, speed, probabilityOfPuncturedWheel) {

    override fun toString(): String {
        return "Vehicle with id: ${this.id}, speed: ${this.speed}, probability: ${this.probabilityOfPuncturedWheel}, type: Car, pass amount: $passengersAmount ."
    }

}