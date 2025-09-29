package arrays

import java.util.Arrays

//All about basics of arrays.
fun main() {

    //initializing the array.
    val arr = arrayOf("amaan", "abbas", "naqvi")
    val arrInt = arrayOf(1, 5, 2, 3)

    //array defining like java
    val intArray = IntArray(5) { it + 1 }
//    println(intArray.contentToString())

    val string = arrayOfNulls<String>(3) //this resembles new String[3] in java.
    val string2 = Array(5) {" n = $it"}
    /* can be used to store all the types of elements in the array,
    depending on the explicitly defined data type. */

//    println(string.contentToString())
//    println(string2.contentToString())

    //Nested arrays
    val nestedArray = Array(3) { Array<Int>(3) { 0 } }

    //accessing nested loop elements.
//    for (i in nestedArray) println(i.contentToString())
    for (innerArray in nestedArray) {
        for (i in innerArray) {
            print(" $i")
        }
        println()
    }

    println(intArray.size)
    println(intArray.sum())
    println(intArray.get(2))
}