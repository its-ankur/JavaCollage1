package ForReference;

public class Node {
    int data; // The data stored in the node
    Node prev; // The reference to the previous node
    Node next; // The reference to the next node

    public Node(int data) { // A constructor to create a new node with the given data
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
