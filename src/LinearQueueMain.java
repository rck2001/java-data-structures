public class LinearQueueMain {
    public static void main(String[] args) {

        LinearQueue q = new LinearQueue(10);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.enqueue(11);
        q.enqueue(22);
        q.enqueue(33);
        q.enqueue(44);
        q.enqueue(55);


        System.out.println("Element at the front of the queue: " + q.peek());
        System.out.println("Current queue: " + q);
        System.out.println("Size: " + q.getSize());
        System.out.println("Is the queue empty?: " + q.isEmpty());
        System.out.println("Is the queue full?: " + q.isFull());
    }
}
