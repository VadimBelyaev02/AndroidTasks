package com.example.myapplication.model

abstract class Vehicle(val id: Int, var speed: Int, var probabilityOfPuncturedWheel: Double) {
    override fun toString(): String {
        return "Vehicle with id: ${this.id}, speed: ${this.speed}, probability: ${this.probabilityOfPuncturedWheel}"
    }
}