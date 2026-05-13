package queue;

public class LinkedListQueue {

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // initial state of the queue
    private int size = 0;
    private Node front = null;
    private Node rear = null;

    // general methods
    public void enqueue(int data) {
        Node newNode = new Node(data);

        if(front == null) {
            front = newNode;
        }

        if(rear == null) {
            rear = newNode;
            size++;
            return;
        }

        rear.next = newNode;
        rear = rear.next;
        size++;
    }
    public int dequeue() {
        if(isEmpty()) { // underflow check
            System.out.println("Queue is empty... Dequeue failed");
            return -1;
        }

        int removed = front.data; // temporarily store the data of the node to be removed
        front = front.next; // moves front pointer forward, i.e, successful dequeue

        if(front == null) { // queue is empty
            rear = null;
        }

        size--;
        return removed;
    }
    public int peek() {
        if(isEmpty()) {
            return -1;
        }

        return front.data;
    }

    // display
    @Override
    public String toString() {
        if(isEmpty()) {
            return "Queue is empty";
        }

        StringBuilder sb = new StringBuilder();

        Node temp = front;
        while(temp != null) {
            sb.append(temp.data).append(" -> ");
            temp = temp.next;
        }
        sb.append("End of the queue");

        return sb.toString();
    }

    // utility methods
    public boolean isEmpty() {
        return size == 0;
    }
    public int getSize() {
        return size;
    }
}
