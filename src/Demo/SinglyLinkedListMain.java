package Demo;

public class SinglyLinkedListMain {
    public static void main(String[] args) {

        linkedlist.SinglyLinkedList list = new linkedlist.SinglyLinkedList();

        list.insertAtBeg(1);
        list.insertAtBeg(2);
        list.insertAtBeg(3);
        list.insertAtBeg(4);
        list.insertAtEnd(5);
        list.insertAtEnd(6);
        list.insertAtEnd(7);
        list.insertAtEnd(8);
        list.insertAtBeg(9);
        list.insertAtBeg(10);
        list.insertAtAnyPos(42332, 3);
        list.insertAtAnyPos(999999999, 12);
        list.insertAtAnyPos(111111111, 1);
        list.deleteAtBeg();
        list.deleteAtEnd();
        list.deleteAtAnyPos(3);
        list.deleteAtAnyPos(2);
        list.display();
    }
}
