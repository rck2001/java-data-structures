package demo;

import stack.LinkedListStack;

public class LinkedListStackMain {
    public static void main(String[] args) {

        LinkedListStack stack = new LinkedListStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.pop(); // removes 4
        stack.pop(); // removes 3
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.pop(); // removes 8
        stack.pop(); // removes 7

        System.out.println(stack.peek());
        System.out.println("Current stack: \n" + stack + "\n");
        System.out.println("Size: " + stack.getSize());
        System.out.println("Is the stack empty?: " + stack.isEmpty());
    }
}
