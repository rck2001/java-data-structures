package Demo;

import linkedlist.DoublyLinkedList;

public class DoublyLinkedListMain {
    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();

        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        list.addFirst(40);
        list.clear();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.addLast(8);
        list.addLast(9);
        list.addLast(10);
        list.removeFirst(); // removes 1
        list.removeFirst(); // removes 2
        list.removeLast(); // removes 10
        list.removeLast(); // removes 9
        list.addIndex(5, 99);
        list.addIndex(5, 45000);
        list.removeIndex(5);
        list.reverse();
        list.addIndex(1, 8);
        list.addIndex(8, 7);
        list.addIndex(4, 99);
        list.addIndex(4, 4);
        //list.removeDuplicates();

        System.out.println("Current list: " + list);
        System.out.println("Size: " + list.getSize());
        System.out.println("Is the list empty?: " + list.isEmpty());

        System.out.println(list.get(10));
        list.set(2, 1);
        list.set(5, 1);
        list.displayForward();
    }
}
