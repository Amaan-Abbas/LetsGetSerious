package arrays

//Program to find the maximum number of consecutive 1's in the array.

fun main() {
    val array = intArrayOf(1, 2, 1, 1, 1, 4, 9, 7, 1, 1, 1, 1, 1, 1)

    var count = 0
    var output = 0

    for (i in array) {
        if (i != 1) {
            if (count > output) {
                output = count
            }
            count = 0
        } else {
            count++
        }
    }

    if (count > output) {
        output = count
    }

    println("Max number of 1's in the array is: $output")
}