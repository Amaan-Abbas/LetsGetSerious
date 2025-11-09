package linkedlist

class SInglyLL {

    var head: KotlinNode? = null

    fun insertionAtEnd(data: Int) {
        val newNode = KotlinNode(data)

        if (head == null) {
            head = newNode
        } else {
            var current = head

            while (current?.next != null) {
                current = current.next
            }
            current?.next = newNode
        }

        println("The Node has been inserted at end!")
    }

    fun insertionAtStart(data: Int) {
        val newNode = KotlinNode(data)

        if (head == null) {
            head = newNode
        } else {
            newNode.next = head
            head = newNode
        }

        println("The Node has been inserted at start!")
    }

    fun insertionAtMiddle(data: Int, position: Int) {
        val newNode = KotlinNode(data)

        if (position == 0) {
            insertionAtStart(data)
            println("The node has been inserted!")
            return
        }

        var current = head
        var count = 1
        while (count < position && current != null) {
            current = current.next
            count++
        }

        if (current == null) {
            println("The position does not exist in the list!")
            return
        }

        newNode.next = current.next
        current.next = newNode

        println("The node has been inserted!")
    }

    fun deleteAtStart() {
        if (head == null) {
            println("The list is empty!")
            return
        } else {
            head = head!!.next

            println("The node has been deleted!")
        }
    }

    fun deleteAtLast() {
        if (head == null) {
            println("The list is empty!")
            return
        }

        var current = head

        while (current?.next?.next != null) {
            current = current.next
        }

        current?.next = null
        println("The node has been deleted!")
    }

    fun deleteAtMiddle(position: Int) {
        if (position == 0) {
            deleteAtStart()
            return
        }

        var count = 1
        var current = head

        while (current != null && count < position) {
            current = current.next
            count++
        }

        if (current == null) {
            println("The po")
        }
    }
}