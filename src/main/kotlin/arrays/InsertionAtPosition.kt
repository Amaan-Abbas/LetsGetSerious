package arrays

import java.util.Scanner

fun main() {
    /* In kotlin, arrays are immutable by default, so they can not be updated with any other values.
    But still there are other methods one can use to make a mutable array(similar):
    1. By copying the elements of the original array into another array and inputting the elements into the new array
    along with the new element using '+' operator.

    2. making an array using the mutableList<>() function; this enables the addition of elements into the original
    array itself by using the .add() function.
     */

    val sc = Scanner(System.`in`)
    print("Enter the initial size of the array: ")
    val n = sc.nextInt()
    println()

    //Cannot use MutableList<>() because unlike mutablelistof(), it is an interface not a class hence not available to use
    //thus returning an error "init not found".
    //Note: You can use MutableList<>() in case of predefining the size of the list, but remember to initialize the
    //the list with default values using the lambda function.
    val array = MutableList<Int>(n) { 0 }

    for (i in 0 until n) {
        print("Enter the element at position ${i + 1}: ")
        val num = sc.nextInt()
        array[i] = num
    }

    println("Initial list is: $array")

    print("Enter the position at which you want to insert the element: ")
    val pos = sc.nextInt()

    print("Enter the value of the element you want to insert: ")
    val num = sc.nextInt()

    array.add(pos - 1, num)

    println("The new array is: $array")
}