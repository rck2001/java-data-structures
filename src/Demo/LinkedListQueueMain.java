package Demo;

import queue.LinkedListQueue;

public class LinkedListQueueMain {
    public static void main(String[] args) {

        LinkedListQueue q = new LinkedListQueue();

        q.enqueue(11);
        q.enqueue(22);
        q.enqueue(33);
        q.enqueue(44);
        q.enqueue(55);
        q.enqueue(66);
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.enqueue(1);
        q.enqueue(10);
        q.enqueue(100);
        q.enqueue(1000);

        System.out.println("Element at the front: " + q.peek());
        System.out.println("Current queue: " + q);
        System.out.println("Size: " + q.getSize());
        System.out.println("Is the queue empty?: " + q.isEmpty());
    }
}
