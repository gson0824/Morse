package com.gson.counter.model

import android.widget.TextView

class LabelChanger {

    private val array = arrayOf("Club Empty", "Occupancy at: ", "Club at Capacity")

    private var firstLabels = StringManager(labels = array, index = 0)
    private var secondLabels = StringManager(labels = array, index = 1)
    private var thirdLabels = StringManager(labels = array, index = 2)

    fun getFirstLabels() = firstLabels.getNextString()
    fun getSecondLabels() = secondLabels.getNextString()
    fun getThirdLabels() = thirdLabels.getNextString()
}