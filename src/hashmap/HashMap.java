package hashmap;

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
    private final Node[] buckets;
    private final int capacity;
    private int size = 0;

    public HashMap(int capacity) {
        this.capacity = capacity;
        this.buckets = new Node[capacity];
    }

    // hash method
    private int hash(String key) {
        return Math.abs(key.hashCode()) % capacity; // has Integer.MIN_VALUE bug
    }

    // put method
    public void put(String key, int value) {
        int index = hash(key);

        Node newNode = new Node(key, value);

        if(buckets[index] != null) { // collision occurs… we do separate chaining to fix this
            // Case 1: check for the same key in the bucket
            Node current = buckets[index];
            while(current != null) {
                if(current.key.equals(key)) {
                    current.value = value;
                    return;
                }

                current = current.next;
            }

            newNode.next = buckets[index];
            buckets[index] = newNode;
            size++;
        }
        else { // when the bucket at the index is empty
            buckets[index] = newNode;
            size++;
        }
    }

    // display hashmap
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
}
