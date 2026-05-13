package demo;

import queue.CircularQueue;

public class CircularQueueMain {
    public static void main(String[] args) {

        CircularQueue q = new CircularQueue(5);

        q.enqueue(22);
        q.enqueue(44);
        q.enqueue(88);
        q.enqueue(55);
        q.enqueue(99);
        System.out.println(q.dequeue()); // removes 22
        System.out.println(q.dequeue()); // removes 44
        System.out.println(q.dequeue()); // removes 88
        System.out.println(q.dequeue()); // removes 55
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5); // overflow

        System.out.println("\nElement at the front of the queue: " + q.peek());
        System.out.println("Current queue: " + q);
        System.out.println("Size: " + q.getSize());
        System.out.println("Is the Queue empty?: " + q.isEmpty());
        System.out.println("Is the Queue full?: " + q.isFull());
    }
}
