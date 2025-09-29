package linkedlist;

public class SinglyLinkedList {

    Node head = null;

    //Function to insert a node into the LL.
    public void insert(int val) {

        Node newNode = new Node(val);

        if (head == null) {
            head = newNode;
            System.out.println("Node has been inserted!");
            return;
        }

        newNode.next = head;
        head = newNode;
        System.out.println("Node has been inserted!");
    }

    //Function to delete a node from the LL.
    public void delete(int val) {
        if (head == null) return;

        Node pointer = head;

        if (pointer.val == val) {
            head = pointer.next;
            System.out.println("Node has been removed!");
            return;
        }

        Node prev = null;

        while (pointer != null && pointer.val != val) {
            prev = pointer;
            pointer = pointer.next;
        }

        if (pointer == null) {
            System.out.println("No such node found!");
            return;
        }

        prev.next = pointer.next;
        System.out.println("Node has been removed!");
    }

    //Function to display the LL.
    public void display() {
        Node temp = head;

        if (temp == null) {
            System.out.println("List is empty!");
            return;
        }

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        System.out.println("END");
    }

    public static void main(String[] args) {
        SinglyLinkedList SLL = new SinglyLinkedList();

        SLL.insert(5);
        SLL.insert(11);
        SLL.insert(7);
        SLL.insert(14);

        SLL.display();

        SLL.delete(7);

        SLL.display();
    }
}
