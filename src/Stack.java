// A stack is a last in first out (LIFO) data structure

public class Stack {

    private final int capacity; // final size once assigned cannot be changed
    private final int[] arr; // final array cannot point to a new array once assigned, so no dynamic resizing
    private int top;

    public Stack(int capacity) {
        if(capacity <= 0) { // check if capacity is valid
            throw new IllegalArgumentException("Size must be greater than 0.");
        }

        this.capacity = capacity;
        this.arr = new int[capacity];
        this.top = -1; // stack is initially empty
    }

    // general methods
    public void push(int data) {
        if(top == capacity - 1) {
            throw new IllegalArgumentException("Stack is full. Stack overflow.");
        }

        top++;
        arr[top] = data;
        // or arr[++top] = data;
        // System.out.println(data + " added to the stack.");
    }
    public int pop() {
        if(top == -1) {
            throw new IllegalArgumentException("Stack is empty. Stack underflow.");
        }

        return arr[top--];
    }
    public int peek() {
        if(top == -1) {
            throw new IllegalArgumentException("Stack is empty.");
        }

        return arr[top];
    }

    // display
    @Override
    public String toString() {
        if(top == -1) {
            return "Stack is empty.";
        }

        StringBuilder sb = new StringBuilder();
        for(int i = top; i >= 0; i--) {
            sb.append(arr[i]).append('\n');
        }

        return sb.toString();
    }

    // utility methods
    public boolean isFull() {
        return top == capacity - 1;
    }
    public boolean isEmpty() {
        return top == -1;
    }
    public int getSize() {
        return top + 1;
    }
}
