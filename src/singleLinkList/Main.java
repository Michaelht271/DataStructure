package singleLinkList;

public class Main {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.insertAtHead(5);
        list.insertAtTail(10);
        list.insertAtPosition(7, 1);  // Inserting 7 at the 1st position
        list.traverse();  // Output: 5 7 10

        System.out.println(list.search(7));  // Output: true
        System.out.println(list.search(11)); // Output: false

        list.reverse();
        list.traverse();  // Output: 10 7 5
    }
}
