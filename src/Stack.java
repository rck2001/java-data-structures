// A stack is a last in first out (LIFO) data structure

public class Stack {

    private int size = 10;
    private int[] arr = new int[size];
    private int top = -1;

    public void push(int data) {
        if(top == size - 1) {
            System.out.println("Stack is full! Stack overflow!");
            return;
        }

        top++;
        arr[top] = data;
        // or arr[++top] = data;
        // System.out.println(data + " added to the stack.");
    }

    public void pop() {
        if(top == -1) {
            System.out.println("Stack is empty! Stack underflow!");
            return;
        }

        System.out.println(arr[top] + " removed from the stack.");
        arr[top] = 0; // not really necessary
        top--;
    }

    public void peek() {
        if(top == -1) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println(arr[top] + " is at the top of the stack.");
    }

    public void display() {
        if(top == -1) {
            System.out.println("Stack is empty!");
            return;
        }

        System.out.println("The current stack: ");
        for(int i = top; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }
}
