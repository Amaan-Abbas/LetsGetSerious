package basics

import java.util.Scanner

fun find(n: Int): Array<Int> {
    val arr = mutableListOf<Int>() //this creates an empty mutable list of type Int.

    /*
    another method is:
    val arr = MutableList(0) {}

    The above is use the MutableList constructor with a size of zero and an initialization lambda, which is useful for
     creating empty lists of a specific type
     */

    for (i in 1..n) {
        if (n % i == 0) {
            arr.add(i)
        }
    }

    //It is used to convert any datatype into a boxed array: Array<T> and not into a primitive type array.
    return arr.toTypedArray()
}

fun main() {
    val sc = Scanner(System.`in`)

    print("Enter the number: ")
    val n = sc.nextInt()

    val arr = find(n)

    println("The number $n is divisible by following numbers: ${arr.contentToString()}")
}