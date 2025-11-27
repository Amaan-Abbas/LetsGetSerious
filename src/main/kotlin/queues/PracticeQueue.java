package queues;

import linkedlist.Node;

public class PracticeQueue {
    private Node front, rear;

    PracticeQueue() {
        this.front = this.rear = null;
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);

        if (rear == null) {
            front = rear = newNode;
            System.out.println("Enqueued!");
            return;
        }

        rear.next = newNode;
        rear = newNode;
        System.out.println("Enqueued!");
    }


    public int dequeue() {
        if (front == null) {
            System.out.println("Queue empty!");
            return -1;
        }

        int value = front.val;
        front = front.next;

        if (front == null) rear = null;

        System.out.println(value + " has been dequeued!");
        return value;
    }

    public int peek() {
        if (front == null) {
            System.out.println("Queue is empty!");
            return -1;
        }

        return front.val;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue id empty!");
            return;
        }

        Node current = front;
        System.out.println("Queue element: ");
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        PracticeQueue queue = new PracticeQueue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display();

        System.out.println("Front element is: " + queue.peek());

        queue.dequeue();
        queue.display();

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();  // Extra dequeue to show empty case
    }
}
