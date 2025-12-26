// Queue is a FIFO (First In First Out) data structure
// The current queue implementation has false overflow
// ,i.e, the rear and front only move forward
// so when the queue is empty because rear < front
// there is empty space in the queue (logically) which is not used

public class LinearQueue {

    private int capacity = 10;
    private int[] arr = new int[capacity];
    int front = -1, rear = -1;

    public void enqueue(int data) {
        if(rear == capacity - 1) {
            System.out.println("Queue is full.");
            return;
        }

        if(front == -1) {
            front = 0;
        }

        arr[++rear] = data;
    }

    public int dequeue() {
        if(rear == -1 || rear < front) {
            System.out.println("Queue is empty.");
            return -1;
        }

        int removed = arr[front];
        front++;
        return removed;
    }

    public int peek() {
        if(rear == -1 || rear < front) {
            System.out.println("Queue is empty.");
            return -1;
        }

        return arr[front];
    }

    @Override
    public String toString() {
        if(rear == -1) {
            return "Queue is empty.";
        }

        StringBuilder sb = new StringBuilder();

        for(int i = front; i <= rear; i++) {
            sb.append(arr[i]).append(" -> ");
        }
        sb.append("End of the queue");

        return sb.toString();
    }
    public boolean isEmpty() {
        return rear == -1 || rear < front;
    }
    public boolean isFull() {
        return rear == capacity - 1;
    }
    public int getSize() {
        if(isEmpty()) {
            return 0;
        }

        return rear - front + 1;
    }
}
