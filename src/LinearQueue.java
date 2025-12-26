// Queue is a FIFO (First In First Out) data structure

// FALSE OVERFLOW = The queue is LOGICALLY EMPTY, but the implementation says FULL.
// The current queue implementation has false overflow.

// We can change the code to reset the queue, i.e, front = rear = -1, when the queue is logically empty.
// But that is suboptimal.
// A circular queue fixes this.

public class LinearQueue<T> {

    private final int capacity;
    private final T[] arr;
    private int front, rear;

    @SuppressWarnings("unchecked")
    public LinearQueue(int capacity) {
        this.capacity = capacity;
        this.arr = (T[]) new Object[capacity];
        this.front = -1;
        this.rear = -1;
    }

    // general methods
    public void enqueue(T data) {
        if(rear == capacity - 1) {
            System.out.println("Queue is full... Queue overflow");
            return;
        }

        if(front == -1) {
            front = 0;
        }

        arr[++rear] = data;
    }
    public T dequeue() {
        if(rear == -1 || rear < front) {
            System.out.println("Queue is empty... Queue underflow");
            return null;
        }

        return arr[front++];
    }
    public T peek() {
        if(rear == -1 || rear < front) {
            return null;
        }

        return arr[front];
    }

    // display
    @Override
    public String toString() {
        if(rear == -1 || rear < front) {
            return "Queue is empty";
        }

        StringBuilder sb = new StringBuilder();

        for(int i = front; i <= rear; i++) {
            sb.append(arr[i]).append(" -> ");
        }
        sb.append("End of the queue");

        return sb.toString();
    }

    // utility methods
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
