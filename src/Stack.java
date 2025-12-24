// A stack is a last in first out (LIFO) data structure

public class Stack {

    private int size = 10;
    private int[] arr = new int[size];
    private int top = -1;

    public void push(int data) {
        if(top == size - 1) {
            System.out.println("Stack is full. Stack overflow.");
            return;
        }

        top++;
        arr[top] = data;
        // or arr[++top] = data;
        // System.out.println(data + " added to the stack.");
    }
    public int pop() {
        if(top == -1) {
            System.out.println("Stack is empty. Stack underflow.");
            return 0;
        }

        return arr[top--];
    }
    public int peek() {
        if(top == -1) {
            System.out.println("Stack is empty.");
            return 0;
        }

        return arr[top];
    }

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
