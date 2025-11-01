package Contest

import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    val input = sc.nextInt()

    for (i in 1..input) {
        val a = sc.nextInt()
        val b = sc.nextInt()
        val c = sc.nextInt()
        val d = sc.nextInt()

        println()
        if (a == b && b == c && c == d) println("Yes") else println("No")
    }
}