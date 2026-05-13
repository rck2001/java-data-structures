package linkedlist;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList1 {

    Node head = null;

    public void insertAtBeg(int data) {
        Node newNode = new Node(data);

        if(head == null) { // when the list is empty
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while(temp.next != null) { // temp stops at the last position
            temp = temp.next;
        }

        temp.next = newNode;
    }
    public void insertAtAnyPos(int data, int pos) {
        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
            return;
        }

        if(pos == 1) {
            insertAtBeg(data);
            return;
        }

        Node temp = head;
        int count = 1;
        while(temp.next != null && count < pos - 1) {
            temp = temp.next;
            count++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }
    public void deleteAtBeg() {

        if(head == null) {
            System.out.println("List is empty.");
            return;
        }

        head = head.next;
    }
    public void deleteAtEnd() {

        if(head == null) {
            System.out.println("List is empty.");
            return;
        }

        if(head.next == null) { // if there is a single element
            deleteAtBeg();
            return;
        }

        Node temp = head;
        while(temp.next.next != null) { // temp stops at the second last position
            temp = temp.next;
        }

        temp.next = null;
    }
    public void deleteAtAnyPos(int pos) {

        if(head == null) {
            System.out.println("List is empty.");
            return;
        }

        if(pos == 1) {
            deleteAtBeg();
            return;
        }

        Node temp = head;
        int count = 1;
        while(temp.next.next != null && count < pos - 1) {
            count++;
            temp = temp.next;
        }

        temp.next = temp.next.next;
    }
    public void display() {
        Node temp = head;

        // if list is empty
        if(head == null) {
            System.out.println("List is empty.");
            return;
        }

        while(temp != null) { // temp stops stop at null position
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}
