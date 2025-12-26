public class StackMain {
    public static void main(String[] args) {

        Stack stack = new Stack(10);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.pop(); // 8 popped
        stack.pop(); // 7 popped
        stack.push(9999);


        System.out.println("Element popped: " + stack.pop()); // 9999 popped
        System.out.println("Current element at the top of the stack is: " + stack.peek());
        System.out.println();
        System.out.println("The stack from top to bottom is: \n" + stack);
        System.out.println("Size: " + stack.getSize());
    }
}
