public class StackMain {
    public static void main(String[] args) {

        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.pop();
        stack.pop();
        stack.pop();

        stack.peek();
        stack.display();
    }
}
