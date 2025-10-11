package linkedlist

fun insertionSortList(head: ListNode?): ListNode? {
    if (head == null || head.next == null) return head //checks if the list is empty or has one node only

    val fakeHead = ListNode(0) //fake head to serve as a sorted list in the linkedList
    var current = head //current node
    while (current != null) {
        var preNode: ListNode? = fakeHead //sorted list
        val nextNode = current!!.next //to store the next value in the original list

        // condition to find the correct place of all the elements
        while (preNode!!.next != null && preNode!!.next!!.`val` <= current!!.`val`) {
            preNode = preNode!!.next
        }

        current!!.next = preNode!!.next // placing the node at the right place
        preNode!!.next = current
        current = nextNode
    }

    return fakeHead!!.next
}