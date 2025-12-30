public class LinkedList2<T> {

    private static class Node<T> {
        // T here is not related to T in the outer class
        // since the inner class is static it doesn't belong to any outer object
        // outer class parameter is replaced by the type received in the object creation
        // so static inner class cannot infer the type T from the outer classes' T parameter
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head = null;
    // parameter T of the outer class is sent as argument to the Node class
    // So the compiler can infer that T of the Node class should be the same as the T of the outer class
    private int size = 0;

    // insertion and deletion methods
    public void insertAtBeg(T data) {
        Node<T> newNode = new Node<>(data);

        if(head == null) { // when the list is empty
            head = newNode;
            size++;
            return;
        }

        newNode.next = head;
        head = newNode;
        size++;
    }
    public void insertAtEnd(T data) {
        Node<T> newNode = new Node<>(data);

        if(head == null) {
            head = newNode;
            size++;
            return;
        }

        Node<T> temp = head;
        while(temp.next != null) { // temp stops at the last position
            temp = temp.next;
        }

        temp.next = newNode;
        size++;
    }
    public void insertAtAnyPosition(T data, int pos) {
        Node<T> newNode = new Node<>(data);

        if(pos < 1 || pos > size + 1) { // check if position is valid [1, size + 1]
            System.out.println("Invalid position.");
            return;
        }

        if(pos == 1) {
            insertAtBeg(data);
            return;
        }

        Node<T> temp = head;
        int count = 1;
        while(temp.next != null && count < pos - 1) {
            temp = temp.next;
            count++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    public void deleteAtBeg() {

        if(head == null) {
            System.out.println("List is empty.");
            return;
        }

        head = head.next;
        size--;
    }
    public void deleteAtEnd() {

        if(head == null) {
            System.out.println("List is empty.");
            return;
        }

        if(head.next == null) { // if there is a single element
            deleteAtBeg();
            return;
        }

        Node<T> temp = head;
        while(temp.next.next != null) { // temp stops at the second last position
            temp = temp.next;
        }

        temp.next = null;
        size--;
    }
    public void deleteAtAnyPosition(int pos) {

        if(pos < 1 || pos > size) {
            System.out.println("Invalid position.");
            return;
        }

        if(pos == 1) {
            deleteAtBeg();
            return;
        }

        Node<T> temp = head;
        int count = 1;
        while(count < pos - 1) {
            count++;
            temp = temp.next;
        }

        temp.next = temp.next.next;
        size--;
    }
    public void removeDuplicates() {
        Node<T> current = head;
        Node<T> runner = null;

        while(current != null) {
            runner = current;

            while(runner.next != null) {
                if(current.data.equals(runner.next.data)) {
                    runner.next = runner.next.next;
                    size--;
                }
                else {
                    runner = runner.next;
                }
            }

            current = current.next;
        }
    }

    // display
    @Override
    public String toString() {
        Node<T> temp = head;

        // if list is empty
        if(head == null) {
            return "List is empty.";
        }

        StringBuilder sb = new StringBuilder();

        while(temp != null) { // temp stops stop at null position
            sb.append(temp.data).append(" -> ");
            temp = temp.next;
        }
        sb.append("NULL");

        return sb.toString();
    }

    // utility methods
    public boolean isEmpty() {
        return head == null;
        // or
        // return size == 0;
    }
    public int getSize() {
        return size;
    }
    public void clear() { // empty the list
        head = null;
        size = 0;
    }
    public boolean contains(T data) {
        return getIndexOf(data) >= 0;
    }
    public int getIndexOf(T data) {
        // returns 0-based index of the element, or -1 if not found or list is empty
        Node<T> temp = head;
        int position = 1;

        while(temp != null) {
            if(temp.data.equals(data)) {
               return position - 1;
            }

            temp = temp.next;
            position++;
        }

        return -1;
    }
    public void reverse() {
        Node<T> previous = null;
        Node<T> current = head;
        Node<T> next = null;

        while(current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        head = previous;
    }

    // add set and get methods
    // use index instead of position
}