package doublyLinkedList;
class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data)
    {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {

    Node head;
    Node tail;

    public DoublyLinkedList()
    {
        this.head = null;
        this.tail = null;
    }
    public void insertAtBeginning(int data)
    {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
            tail = temp;
        }
        else {
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
    }
    public void insertAtEnd(int data){
        Node temp=new Node(data);
        if(temp==null){
            head=temp;
            tail=temp;
        }
        else {
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }
    }
}


public class DoublyLinkedListQuestion {
    public static void main(String[] args) {

    }
}
