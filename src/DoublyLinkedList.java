public class DoublyLinkedList {

    private static class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    // initial list
    private Node head = null;
    private Node tail = null;
    private int size = 0;

    // insert and delete methods
    public void addFirst(int data) {
        Node newNode = new Node(data);

        if(isEmpty()) {
            head = tail = newNode;
        }
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        size++;
    }
    public void addLast(int data) {
        Node newNode = new Node(data);

        if(isEmpty()) {
            head = tail = newNode;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        size++;
    }
    public void addIndex(int index, int data) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }

        // index = 0 or index = size
        if(index == 0) {
            addFirst(data);
            return;
        }
        if(index == size) {
            addLast(data);
            return;
        }

        Node newNode = new Node(data);
        Node current;

        if(index < size / 2) { // traverse from head
            current = head;
            for(int i = 0; i < index; i++) {
                current = current.next;
            }
        }
        else { // traverse from tail
            current = tail;
            for(int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }

        newNode.next = current;
        newNode.prev = current.prev;
        current.prev.next = newNode;
        current.prev = newNode;

        size++;
    }

    public void removeFirst() {
        if(isEmpty()) {
            throw new IllegalStateException("Cannot remove first element from an empty list");
        }

        if(head == tail) { // single element
            head = tail = null;
        }
        else {
            head = head.next;
            head.prev = null;
        }

        size--;
    }
    public void removeLast() {
        if(isEmpty()) {
            throw new IllegalStateException("Cannot remove last element from an empty list");
        }

        if(head == tail) { // single element
            head = tail = null;
        }
        else {
            tail = tail.prev;
            tail.next = null;
        }

        size--;
    }
    public void removeIndex(int index) {
        if(index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }

        // first and last index
        if(index == 0) {
            removeFirst();
            return;
        }
        if(index == size - 1) {
            removeLast();
            return;
        }

        Node current;

        if(index < size / 2) { // traverse from head
            current = head;
            for(int i = 0; i < index; i++) {
                current = current.next;
            }
        }
        else { // traverse from tail
            current = tail;
            for(int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }

        current.prev.next = current.next;
        current.next.prev = current.prev;
        current.prev = null;
        current.next = null;

        size--;
    }
    public void removeDuplicates() {
        if(isEmpty() || size == 1) {
            return;
        }

        Node current = head;

        while(current != null) {
            Node runner = current;

            while(runner.next != null) {
                if(current.data == runner.next.data) {
                    // optional
                    Node duplicate = runner.next; // duplicate node to be removed

                    // main logic
                    runner.next = runner.next.next;
                    if(runner.next != null) {
                        runner.next.prev = runner;
                    }
                    else { // after the update, runner now points to null
                        tail = runner;
                    }

                    // optional
                    duplicate.next = null;
                    duplicate.prev = null;

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
    public void displayForward() {
        if(isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;
        while(current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("NULL");
    }
    public void displayBackward() {
        if(isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node current = tail;
        while(current != null) {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }
        System.out.println("NULL");
    }
    @Override
    public String toString() { // returns the list in forward direction
        if(isEmpty()) {
            return "List is empty";
        }

        StringBuilder sb = new StringBuilder();

        Node current = head;
        while(current != null) {
            sb.append(current.data).append(" <-> ");
            current = current.next;
        }
        sb.append("NULL");

        return sb.toString();
    }

    // utility methods
    public boolean isEmpty() {
        return size == 0; // or head == null or tail == null or head == null && tail == null
    }
    public int getSize() {
        return size;
    }
    public void clear() {
        head = tail = null;
        size = 0;
    }

    public boolean contains(int data) {
        return indexOf(data) >= 0;
    }
    public int indexOf(int data) {
        if(isEmpty()) return -1; // optional

        Node current = head;
        int index = 0;

        while(current != null) {
            if(current.data == data) return index;

            index++;
            current = current.next;
        }

        return -1;
    }
    public int lastIndexOf(int data) {
        if(isEmpty()) return -1; // optional

        // main logic
        Node current = tail;
        for(int index = size - 1; index >= 0; index--) {
            if(current.data == data) return index;

            current = current.prev;
        }

        return -1;
    }
    public void reverse() {
        // for single element list or empty list, to prevent unnecessary work
        // works the same without this line too
        if(head == null || head == tail) return;

        Node current = head;
        while(current != null) {
            Node temp = current.prev;
            current.prev = current.next;
            current.next = temp;

            current = current.prev; // helps in traversing the list
        }

        Node temp = head;
        head = tail;
        tail = temp;
    }

    // getters and setters
    public void set(int index, int data) {
        // check if index is valid
        if(index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }

        Node current;

        if(index < size / 2) {
            current = head;
            for(int i = 0; i < index; i++) {
                current = current.next;
            }
        }
        else {
            current = tail;
            for(int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }

        current.data = data;
    }
    public int get(int index) {
        // check if index is valid
        if(index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }

        Node current;

        if(index < size / 2) { // traverse from head
            current = head;
            for(int i = 0; i < index; i++) {
                current = current.next;
            }
        }
        else { // traverse from tail
            current = tail;
            for(int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }

        return current.data;
    }
}
