package queues

class ArrayQueue(
    var arr: IntArray = intArrayOf(1, 2, 3, 4, 5)

) {

    //function to insert an element in the queue.
    fun enqueue(n: Int, arr: MutableList<Int>) {

    }

    //function to remove an element for the list.
    fun dequeue(arr: MutableList<Int>) {

    }

    //function to check whether the queue is full or not.
    fun isFull(arr: MutableList<Int>, size: Int): Int {
        if (arr.size == size) {
            println("Array is ful!")
            return 0
        } else {
            println("Array is yet to be filled")
            return -1
        }
    }

    //function to check if the queue is empty or not.
    fun isEmpty(arr: MutableList<Int>): Int {
        if (arr.size == 0) {
            println("Array is empty")
            return 0
        } else {
            println("Array contains some elements")
            return -1
        }
    }

}