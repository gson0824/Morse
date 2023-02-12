package com.gson.memegenerator.model


import com.gson.memegenerator.R


class Meme {
    fun generate_meme(n: Int): Int {
        val images = arrayOf(
            R.drawable.cry,
            R.drawable.happy,
            R.drawable.normal,
            R.drawable.punch,
            R.drawable.rage,
            R.drawable.sad,
            R.drawable.thinking,
            R.drawable.wtf
        )
        return images[n]
    }

    fun generate_text(n: Int): String {
        var caption = ""
        when (n) {
            0 -> caption = "Cry"
            1 -> caption = "Happy"
            2 -> caption = "Normal"
            3 -> caption = "Punch"
            4 -> caption = "Rage"
            5 -> caption = "Sad"
            6 -> caption = "Thinking"
            7 -> caption = "Wtf"
        }
        return caption
    }
}