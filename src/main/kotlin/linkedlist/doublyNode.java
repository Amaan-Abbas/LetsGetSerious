package linkedlist;

public class doublyNode{
    int val;
    doublyNode next;
    doublyNode prev;


    doublyNode() {
        val = 0;
        next = null;
        prev = null;
    }

    doublyNode(int val) {
        this.val = val;
        next = null;
        prev = null;
    }

    doublyNode(int val, doublyNode next) {
        this.next = next;
        this.val  =val;
        prev = null;
    }

    doublyNode(int val, doublyNode next, doublyNode prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}
