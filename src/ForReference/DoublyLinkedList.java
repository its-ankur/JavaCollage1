package ForReference;// A class to represent a node of a doubly linked list


// A class to represent a doubly linked list
public class DoublyLinkedList {
    Node head; // The reference to the first node of the list
    Node tail; // The reference to the last node of the list

    public DoublyLinkedList() { // A constructor to create an empty list
        this.head = null;
        this.tail = null;
    }

    // A method to insert a new node at the beginning of the list
    public void insertAtBeginning(int data) {
        Node temp = new Node(data); // Create a new node with the given data
        if (head == null) { // If the list is empty, set both head and tail to the new node
            head = temp;
            tail = temp;
        } else { // Otherwise, set the next pointer of the new node to the current head
            temp.next = head;
            head.prev = temp; // Set the previous pointer of the current head to the new node
            head = temp; // Set the new node as the new head of the list
        }
    }

    // A method to insert a new node at the end of the list
    public void insertAtEnd(int data) {
        Node temp = new Node(data); // Create a new node with the given data
        if (tail == null) { // If the list is empty, set both head and tail to the new node
            head = temp;
            tail = temp;
        } else { // Otherwise, set the previous pointer of the new node to the current tail
            temp.prev = tail;
            tail.next = temp; // Set the next pointer of the current tail to the new node
            tail = temp; // Set the new node as the new tail of the list
        }
    }

    // A method to insert a new node at a given position in the list
    public void insertAtPosition(int data, int position) {
        Node temp = new Node(data); // Create a new node with the given data
        if (position < 1) { // If the position is invalid, print an error message and return
            System.out.println("Invalid position");
            return;
        }
        if (position == 1) { // If the position is 1, insert at the beginning of the list
            insertAtBeginning(data);
            return;
        }
        Node current = head; // Initialize a pointer to traverse the list from head
        int count = 1; // Initialize a counter to keep track of the position
        while (current != null && count < position - 1) { // Loop until we reach one position before or end of the list
            current = current.next; // Move to the next node in the list
            count++; // Increment the counter by 1
        }
        if (current == null) { // If we reached end of the list, insert at end of it
            insertAtEnd(data);
            return;
        }
        temp.next = current.next; // Set next pointer of new node to next pointer of current node
        if (current.next != null) { // If current node is not last node, set prev pointer of next node to new node
            current.next.prev = temp;
        }
        current.next = temp; // Set next pointer of current node to new node
        temp.prev = current; // Set prev pointer of new node to current node
    }

    // A method to delete a node from beginning of list
    public void deleteFromBeginning() {
        if (head == null) { // If list is empty, print an error message and return
            System.out.println("List is empty");
            return;
        }
        if (head == tail) { // If there is only one node in list, set both head and tail to null
            head = null;
            tail = null;
            return;
        }
        head = head.next; // Set head to next node in list
        head.prev = null; // Set prev pointer of new head to null
    }

    // A method to delete a node from end of list
    public void deleteFromEnd() {
        if (tail == null) { // If list is empty, print an error message and return
            System.out.println("List is empty");
            return;
        }
        if (head == tail) { // If there is only one node in list, set both head and tail to null
            head = null;
            tail = null;
            return;
        }
        tail = tail.prev; // Set tail to previous node in list
        tail.next = null; // Set next pointer of new tail to null
    }

    // A method to delete a node from a given position in list
    public void deleteFromPosition(int position) {
        if (position < 1) { // If the position is invalid, print an error message and return
            System.out.println("Invalid position");
            return;
        }
        if (position == 1) { // If the position is 1, delete from beginning of list
            deleteFromBeginning();
            return;
        }
        Node current = head; // Initialize a pointer to traverse the list from head
        int count = 1; // Initialize a counter to keep track of the position
        while (current != null && count < position) { // Loop until we reach the position or end of the list
            current = current.next; // Move to the next node in the list
            count++; // Increment the counter by 1
        }
        if (current == null) { // If we reached end of the list, print an error message and return
            System.out.println("Position out of bounds");
            return;
        }
        if (current == tail) { // If current node is last node, delete from end of list
            deleteFromEnd();
            return;
        }
        current.prev.next = current.next; // Set next pointer of previous node to next pointer of current node
        current.next.prev = current.prev; // Set prev pointer of next node to prev pointer of current node
    }

    // A method to traverse the list from head to tail and print the data of each node
    public void traverseForward() {
        Node current = head; // Initialize a pointer to traverse the list from head
        while (current != null) { // Loop until we reach end of the list
            System.out.print(current.data + " "); // Print the data of the current node
            current = current.next; // Move to the next node in the list
        }
    }

    // A method to traverse the list from tail to head and print the data of each node
    public void traverseBackward() {
        Node current = tail; // Initialize a pointer to traverse the list from tail
        while (current != null) { // Loop until we reach beginning of the list
            System.out.print(current.data + " "); // Print the data of the current node
            current = current.prev; // Move to the previous node in the list
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList(); // Create an empty doubly linked list
        dll.insertAtBeginning(10); // Insert 10 at beginning of list
        dll.insertAtEnd(20); // Insert 20 at end of list
        dll.insertAtPosition(15, 2); // Insert 15 at position 2 in list
        dll.deleteFromBeginning(); // Delete from beginning of list
        dll.deleteFromEnd(); // Delete from end of list
        dll.deleteFromPosition(2); // Delete from position 2 in list
        dll.traverseForward(); // Traverse and print the list from head to tail
    }
}
