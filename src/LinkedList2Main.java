public class LinkedList2Main {
    public static void main(String[] args) {

        LinkedList2<Integer> list = new LinkedList2<>();

        list.insertAtBeg(1);
        list.insertAtBeg(2);
        list.insertAtBeg(3);
        list.insertAtEnd(11);
        list.insertAtEnd(22);
        list.insertAtEnd(33);
        list.insertAtAnyPosition(111, 7);
        list.insertAtAnyPosition(222, 1);
        list.deleteAtBeg();
        list.deleteAtEnd();
        list.deleteAtAnyPosition(3);
        list.reverse();
        System.out.println(list.getIndexOf(33));

        System.out.println(list);
        System.out.println("Size: " + list.getSize());
        System.out.println("Is the list empty?: " + list.isEmpty());
    }
}
