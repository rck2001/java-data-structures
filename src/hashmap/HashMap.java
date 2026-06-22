package hashmap;

import java.util.Objects;

public class HashMap {

    private static class Node {
        String key;
        int value;
        Node next;

        private Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // initial hashmap
    private int capacity;
    private Node[] buckets;
    private int size = 0;
    private final float loadFactor = 0.75f;

    public HashMap() {
        this.capacity = 16;
        this.buckets = new Node[capacity];
    }
    public HashMap(int capacity) {
        if(capacity <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0");
        }
        this.capacity = capacity;
        this.buckets = new Node[capacity];
    }

    // put, remove and get method
    public void put(String key, int value) {
        int index = hash(key);

        // check if the key already exists
        Node current = buckets[index];
        while(current != null) {
            if(Objects.equals(current.key, key)) {
                current.value = value; // key found, update value
                return; // exit
            }

            current = current.next;
        }

        // key not found
        // create a key-value pair and add to the front
        Node newNode = new Node(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;

        size++;

        // CHECK IF THE BUCKETS ARRAY NEED RESIZING
        if(size > (capacity * loadFactor)) {
            resize();
        }
    }
    public Integer remove(String key) {
        int index = hash(key);

        Node current = buckets[index];
        if(current == null) { // empty bucket
            return null;
        }
        if(Objects.equals(current.key, key)) { // key present at first node
            buckets[index] = buckets[index].next;
            size--;

            return current.value;
        }

        while(current.next != null) {
            if(Objects.equals(current.next.key, key)) {
                int removedValue = current.next.value;

                current.next = current.next.next;
                size--;

                return removedValue;
            }

            current = current.next;
        }

        return null;
    }
    public Integer get(String key) {
        int index = hash(key);

        Node current = buckets[index];
        while(current != null) {
            if(Objects.equals(current.key, key)) {
                return current.value;
            }

            current = current.next;
        }

        return null;
    }

    // display methods
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");

        boolean first = true;
        for(int i = 0; i < capacity; i++) {
            Node current = buckets[i];

            while(current != null) {
                if(!first) sb.append(", ");
                sb.append(current.key).append("=").append(current.value);

                current = current.next;
                first = false;
            }
        }
        sb.append("}");

        return sb.toString();
    }
    public void displayCollisionMapping() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < capacity; i++) {
            sb.append("Bucket ").append(i).append(": ");
            Node current = buckets[i];

            boolean first = true;

            while(current != null) {
                if(!first) sb.append(", ");
                sb.append(current.key).append("=").append(current.value);

                current = current.next;
                first = false;
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    // utility methods
    public int size() {
        return size;
    }
    public void clear() {
        for(int i = 0; i < capacity; i++) {
            buckets[i] = null;
        }

        size = 0;
    }

    // helpers
    private int hash(String key) {
        if(key == null) {
            return 0;
        }

        return (key.hashCode() & 0x7fffffff) % capacity;
    }
    private void resize() {
        capacity *= 2;

        Node[] OldBuckets = buckets;
        buckets = new Node[capacity];

        // we are reusing old nodes instead of creating new ones
        for(int i = 0; i < OldBuckets.length; i++) {
            Node current = OldBuckets[i];

            while(current != null) {
                Node nextOldNode = current.next;

                // calculate new index based on new capacity
                int newIndex = hash(current.key);

                // insert nodes at the front
                current.next = buckets[newIndex];
                buckets[newIndex] = current;

                // update the current to the next node in the old bucket list
                current = nextOldNode;
            }
        }
    }
}
