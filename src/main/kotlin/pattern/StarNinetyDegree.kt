package pattern

import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    print("How many lines of pattern do you want to print: ")
    val n = sc.nextInt()
    println()

    for (i in 1 .. n) {
        for (j in 1 .. i) {
            print("* ")
        }
        println()
    }
}