package com.gson.counter.model

class LabelChanger {

    private val array = arrayOf("Club Empty", "Club at Capacity", "Occupancy at: X")

    private var firstLabels = StringManager(labels = array, index = 0)
    private var secondLabels = StringManager(labels = array, index = 1)

    fun getFirstLabels() = firstLabels.getNextString()
    fun getSecondLabels() = secondLabels.getNextString()
}