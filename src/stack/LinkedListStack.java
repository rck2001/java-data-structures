package stack;

// LIFO data structure
public class LinkedListStack {

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // initial stack
    int size = 0;
    Node top = null;

    // general methods
    public void push(int data) {
        Node newNode = new Node(data);

        newNode.next = top;
        top = newNode;
        size++;
    }
    public int pop() {
        if(isEmpty()) {
            System.out.println("Stack is empty... Stack Underflow");
            return -1;
        }

        int removed = top.data;
        top = top.next;
        size--;
        return removed;
    }
    public int peek() {
        if(isEmpty()) {
            return -1;
        }

        return top.data;
    }

    // display
    @Override
    public String toString() {
        if(isEmpty()) {
            return "Stack is empty";
        }

        StringBuilder sb = new StringBuilder();
        Node temp = top;

        while(temp != null) {
            sb.append(temp.data).append(" -> \n");
            temp = temp.next;
        }
        sb.append("NULL");

        return sb.toString();
    }

    // utility methods
    public boolean isEmpty() {
        return size == 0; // or return top == null;
    }
    public int getSize() {
        return size;
    }
}
