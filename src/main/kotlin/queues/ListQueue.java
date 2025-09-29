package queues;

import linkedlist.Node;

public class ListQueue {
    static Node head;
    static Node tail;
    static int count;
    static int size;

    ListQueue(int size) {
        head = null;
        tail = null;
        count = 0;
        ListQueue.size = size;
    }

    public static void enqueue(int val) {

        if (isFull()) {
            System.out.println("Queues is full!");
            return;
        }

        Node newNode = new Node(val);

        if (head == null) {
            head = newNode;
            tail = head;
            count++;
            System.out.println("Element has been enqueued!");
            return;
        }

        tail.next = newNode;
        tail = newNode;
        count++;
        System.out.println("Element has been enqueued!");
    }

    public static void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }

        head = head.next;
        count--;
        System.out.println("Queue is dequeued!");
    }

    public static boolean isEmpty() {
        return count == 0;
    }

    public static boolean isFull() {
        return count == size;
    }
}
