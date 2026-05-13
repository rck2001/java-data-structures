package queue;

public class CircularQueue {

    // initial queue
    private final int capacity;
    private final int[] arr;
    private int front, rear;
    private int size;

    public CircularQueue(int capacity) {
        // initial queue
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.front = -1;
        this.rear = -1;
        this.size = 0;
    }

    // general methods
    public void enqueue(int data) {
        if(isFull()) {
            System.out.println("Queue is full... Queue overflow");
            return;
        }

        if(front == -1) {
            front = 0;
        }

        rear = (rear + 1) % capacity;
        arr[rear] = data;
        size++;
    }
    public int dequeue() {
        if(isEmpty()) {
            System.out.println("Queue is empty... Queue underflow");
            return -1;
        }

        int removed = arr[front];

        if(size == 1) { // only one element is present
            front = rear = -1; // resets the indices, i.e, the queue is now empty
        }
        else {
            front = (front + 1) % capacity;
        }

        size--;
        return removed;
    }
    public int peek() {
        if(isEmpty()) {
            return -1;
        }

        return arr[front];
    }

    // display
    @Override
    public String toString() {
        if(isEmpty()) {
            return "Queue is empty";
        }

        StringBuilder sb = new StringBuilder();
        for(int i = front, count = 1; count <= size; count++, i = (i + 1) % capacity) {
            sb.append(arr[i]).append(" -> ");
        }
        sb.append("End of queue");

        return sb.toString();
    }

    // utility methods
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean isFull() {
        return size == capacity;
    }
    public int getSize() {
        return size;
    }
}
