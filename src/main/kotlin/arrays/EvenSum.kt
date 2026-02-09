package arrays

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()

    val arr = IntArray(n)
    val str = Array(n) { "" }

    for (i in 0 until n) {
        arr[i] = scanner.nextInt()
        str[i] = scanner.next()
    }

    for (num in arr) {
        if (num % 2 == 0) println(num)
    }

    for (s in str) println(s)
}