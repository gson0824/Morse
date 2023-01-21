package mykotlintest

fun main() {
    val arrayOne = arrayOf("one", "two", "three")
    arrayOne.forEach {
        print("$it")
    }
    println("\n")

    val arrayTwo = IntArray(3)
    printArray(arrayTwo)

    val arrayThree = IntArray(3) { 42 }
    printArray(arrayThree)

    val arrayFour = IntArray(333) {it * 2}
    printArray(arrayFour)

    arrayFour[1] = 15
    printArray(arrayFour)
}

fun printArray(ar: IntArray) {
    ar.forEach {
        print("$it\n")
    }
    println()
}