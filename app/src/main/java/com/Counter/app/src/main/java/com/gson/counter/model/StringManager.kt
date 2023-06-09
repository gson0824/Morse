package com.gson.counter.model

class StringManager(var labels: Array<String>, var index: Int) {

    fun getNextString(): String {
        if (index == labels.size) {
            index = 0
        }

        return labels[index]
    }
}