package com.csc.model

class Counter constructor(var cur: Int = 0, var max: Int = 5) {

    fun atMax() = cur >= max
    fun roomLeft() = max - cur
    fun reset() { cur = 0 }

    fun add() {
        if (cur < max) {
            cur += 1
        }
    }

    fun remove() {
        if (cur > 0) {
            cur -= 1
        }
    }
}