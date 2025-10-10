package recursion

import kotlin.math.abs

fun myPow(x: Double, n: Int): Double {
    var base = x
    var power = n
    var result = 1.0

    // Handle negative exponent
    if (power < 0) {
        base = 1 / base
        power = -power
    }

    // Fast exponentiation (binary exponentiation)
    while (power != 0) {
        if ((power and 1) != 0) {
            result *= base
        }
        base *= base
        power = power ushr 1
    }

    return result
}

fun main() {
    println(myPow(34.00515, -3))
}