package Contest

import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    val input = sc.nextInt()

    for (i in 1..input) {
        val size = sc.nextInt()
        val cubes = sc.next().toCharArray().sortedArray()
        val name = sc.next().toCharArray().sortedArray()

        println()

        if (cubes.size != size || name.size != size) {
            println("No")
            break
        }

        for (i in 0 until size) {
            if (cubes[i] != name[i]) {
                println("No")
                break
            }

            if (i == size - 1) println("Yes")
        }
    }
}