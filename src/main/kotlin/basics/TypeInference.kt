package basics

import kotlin.math.sqrt

fun main() {
    val numbers = listOf(1, 2, 3)
    val result = numbers.map { it * 2 }
    println(result)

    val input = readln()
    val number = input.toIntOrNull()?.rem(2)?.equals(0) ?: -1

    println(number)
    var check = mutableListOf<Double>(0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 2.0, 0.0, 1.0)
    check.removeAll { it == 0.0 }
    val newCheck = check.toDoubleArray()
    println(newCheck.contentToString())
    val num = sqrt(4.0)
    println(num)
}