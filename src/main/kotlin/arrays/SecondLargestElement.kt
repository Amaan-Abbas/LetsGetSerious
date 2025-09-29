package arrays

import java.util.Scanner

//Object works the same way as "companion object" the difference is that the "object ..." allows the whole class
//block to be associated to the class rather than being associated with the object of the class.
//Whereas the "companion object" is used where a certain block of code in the class is to be associated with the
//class and not the whole class block.
object SecondLargestElement {

    /*companion object is used to associate the member functions and properties directly to the class and not
    to the object created for the class. This allows easy access of the member functions and variables to the
    classes accessing the companion object class.
     */
//    companion object {
        private var largest = Int.MIN_VALUE
        private var secondLargest = Int.MIN_VALUE

        fun secondLargestElement(i: IntArray): Int {
            for (i in i) {
                if (i > largest) {
                    secondLargest = largest
                    largest = i
                } else if (secondLargest < i) {
                    secondLargest = i
                }
            }

            return secondLargest
        }
//    }
}

fun main() {
    val sc = Scanner(System.`in`)
    print("Enter the size of the array: ")
    val n = sc.nextInt()

    val arr = IntArray(n)

    println("Enter the elements of the array: ")
    for (i in 0 until n) {
        arr[i] = sc.nextInt()
    }

    val result = SecondLargestElement.secondLargestElement(arr)
    println("The second largest element in the array is: $result")
}