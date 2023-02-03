package com.gson.morse.model

class Morse {
    fun encodeMessage(message: String): String {
        var output = ""
        for (c in message) {
            output += encodeCharacter(c)
        }
        return output
    }

    private fun encodeCharacter(char: Char) = when (char) {
        'A' -> ".-"
        'B' -> "-..."
        'C' -> "-.-."
        'D' -> "-.."
        'E' -> "."
        'F' -> "..-."
        'G' -> "--."
        'H' -> "...."
        'I' -> ".."
        'J' -> ".---"
        'K' -> "-.-"
        'L' -> ".-.."
        'M' -> "--"
        'N' -> "-."
        'O' -> "---"
        'P' -> ".--."
        'Q' -> "--.-"
        'R' -> ".-."
        'S' -> "..."
        'T' -> "-"
        'U' -> "..-"
        'V' -> "...-"
        'W' -> ".--"
        'X' -> "-..-"
        'Y' -> "-.--"
        'Z' -> "--.."
        ' ' -> " "
        else -> " "
    }
}