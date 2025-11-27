package linkedlist;

public class DoublyLinkedList {

    doublyNode head, tail;

    DoublyLinkedList() { head = tail = null; }

    void insertAtFront(int val) {
        doublyNode newNode = new doublyNode(val);
        if (head == null) {
            head = tail = newNode;
            System.out.println("Node has been inserted!");
            return;
        }

        newNode.next = head;
        head = newNode;
        newNode.prev = null;
        System.out.println("Node has been inserted!");
    }

    void insertAtBack(int val) {
        doublyNode newNode = new doublyNode(val);

        if (tail == null) {
            head = tail = newNode;
            System.out.println("Node has been inserted!");
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        System.out.println("Node has been inserted!");
    }

//    void insertAtMid(int val, int position) {
//        doublyNode newNode = new doublyNode(val);
//
//        if (h)
//    }

    void deleteAtFront() {
        if (head == null) {
            System.out.println("The list is empty!");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        System.out.println("The node has been deleted!");
    }

    void deleteAtBack() {
        if (tail == null) {
            System.out.println("The list is empty!");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        System.out.println("The node has been deleted!");
    }

    void display() {
        doublyNode pointer = head;

        while (pointer != null) {
            System.out.print(pointer.val + " -> ");
            pointer = pointer.next;
        }

        System.out.println("END");
    }

    public static void main(String[] args) {
        DoublyLinkedList dLL = new DoublyLinkedList();

//        dLL.insertAtBack(5);
//        dLL.insertAtBack(6);
//        dLL.insertAtBack(11);
//        dLL.insertAtBack(2);

        dLL.insertAtFront(5);
        dLL.insertAtFront(6);
        dLL.insertAtFront(11);
        dLL.insertAtFront(2);

        dLL.display();

        dLL.deleteAtFront();

        dLL.display();
    }
}
