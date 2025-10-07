package linkedlist

import java.util.LinkedList

fun main() {
    val arr = intArrayOf(1,2,3)
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next!!.next = ListNode(3)
    head.next!!.next!!.next = ListNode(4)
    head.next!!.next!!.next!!.next = ListNode(5)

    println(modifiedList(arr, head).toString())
}

fun modifiedList(nums: IntArray, head: ListNode?): ListNode? {

    //to find the max element in the array
    val max: (IntArray) -> Int = {max ->
        var temp = 0
        for (i in max) {
            if (temp < i) temp = i
        }
        temp
    }
    val size = max(nums)

    //creating a boolean array in for getting the elements to be removed
    val arr = BooleanArray(size + 1)
    for (i in nums) {
        arr[i] = true
    }

    //new head for the removed node
    var preNode: ListNode? = ListNode(0)
    val dummyHead = preNode
    var pointer = head

    while (pointer != null) {
        val value = pointer.`val`

        //if the value of the node is greater than the size of the array or its value in the boolean
        //array is false then add to the new list
        if (value !in 0..size || !arr[value]) {
            val newNode = ListNode(value)
            preNode!!.next = newNode
            preNode = preNode.next
        }
        pointer = pointer.next
    }

    return dummyHead!!.next //return the head of the new List
}