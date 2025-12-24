// A stack is a last in first out (LIFO) data structure

public class Stack {

    private final int size; // final size once assigned cannot be changed
    private final int[] arr; // final array cannot point to a new array once assigned, so no dynamic resizing
    private int top = -1;

    public Stack(int size) {
        if(size <= 0) { // check if size is valid
            throw new IllegalArgumentException("Size must be greater than 0.");
        }

        this.size = size;
        this.arr = new int[size];
    }

    // general methods
    public void push(int data) {
        if(top == size - 1) {
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

    // display the array
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
}
