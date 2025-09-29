package linkedlist;

public class Node {

    public Node next;
    public int val;


    public Node() {
        val = 0;
        next = null;
    }

    public Node(int val) {
        this.val = val;
        next = null;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}
