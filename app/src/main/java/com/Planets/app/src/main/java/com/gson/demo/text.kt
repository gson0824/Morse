package com.gson.demo

class text(private var planetIndex: Int = 0) {

    private val planets = arrayOf(
        "Neptune", "Uranus", "Saturn", "Jupiter", "Mars","Earth", "Venus", "Mercury"
    )

    fun getNextPlanet(): String {
        planetIndex++
        if (planetIndex == planets.size) {
            planetIndex = 0
        }
        return planets[planetIndex]
    }

    fun hello(): String = "Hello, everyone"
}