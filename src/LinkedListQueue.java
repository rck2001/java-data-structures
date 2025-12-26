public class LinkedListQueue<T> {

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    // initial state of the queue
    private int size = 0;
    private Node<T> front = null;
    private Node<T> rear = null;

    // general methods
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);

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
    public T dequeue() {
        if(isEmpty()) { // underflow check
            System.out.println("Queue is empty... Dequeue failed");
            return null;
        }

        T removed = front.data; // temporarily store the data of the node to be removed
        front = front.next;
        size--;

        if(front == null) { // queue is empty
            rear = null;
        }

        return removed;
    }
    public T peek() {
        if(isEmpty()) {
            return null;
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

        Node<T> temp = front;
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
