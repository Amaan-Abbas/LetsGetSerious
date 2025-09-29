package recursion

fun factorial(i: Int): Int {
    if (i == 0 || i == 1) return 1
    return i * factorial(i - 1)
}

fun main() {
    println(factorial(3))
}