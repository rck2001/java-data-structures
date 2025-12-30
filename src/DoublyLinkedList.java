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
    public void addIndex(int data, int index) {
        if(index < 0 || index > size) {
            System.out.println("Invalid index");
            return;
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
        Node temp;

        if(index < size / 2) { // traverse from head
            temp = head;
            for(int i = 0; i < index; i++) {
                temp = temp.next;
            }
        }
        else { // traverse from tail
            temp = tail;
            for(int i = size - 1; i > index; i--) {
                temp = temp.prev;
            }
        }

        newNode.next = temp;
        newNode.prev = temp.prev;
        temp.prev.next = newNode;
        temp.prev = newNode;

        size++;
    }
    public void removeFirst() {
        if(isEmpty()) {
            System.out.println("List is empty... Cannot remove");
            return;
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
            System.out.println("List is empty... Cannot remove");
            return;
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
            System.out.println("Invalid index");
            return;
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

        Node temp;

        if(index < size / 2) { // traverse from head
            temp = head;
            for(int i = 0; i < index; i++) {
                temp = temp.next;
            }
        }
        else { // traverse from tail
            temp = tail;
            for(int i = size - 1; i > index; i--) {
                temp = temp.prev;
            }
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.prev = null;
        temp.next = null;

        size--;
    }

    // display
    public void displayForward() {
        if(isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("NUll");
    }
    public void displayBackward() {
        if(isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node temp = tail;
        while(temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("NULL");
    }
    @Override
    public String toString() { // returns the list in forward direction
        if(isEmpty()) {
            return "List is empty";
        }

        StringBuilder sb = new StringBuilder();

        Node temp = head;
        while(temp != null) {
            sb.append(temp.data).append(" <-> ");
            temp = temp.next;
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
        head = null;
        tail = null;
        size = 0;
    }

    public boolean contains(int data) {
        return indexOf(data) >= 0;
    }
    public int indexOf(int data) {
        Node temp = head;
        int index = 0;

        while(temp != null) {
            if(temp.data == data) return index;

            index++;
            temp = temp.next;
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
            current = current.prev;
        }

        Node temp = head;
        head = tail;
        tail = temp;
    }

    // add set, get, remove duplicates and reverse methods method
}
