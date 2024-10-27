package priorutyQueueByLinkList;

public class Main {
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        
        pq.enqueue(5, 2);
        pq.enqueue(4, 1);
       
        pq.enqueue(6, 0);
        pq.enqueue(7, 3);

        pq.display(); // Output: (7, 3) (5, 2) (4, 1) (6, 0)

        System.out.println("Dequeue: " + pq.dequeue()); // Output: 7
        System.out.println("Peek: " + pq.peek()); // Output: 5

        pq.display(); // Output: (5, 2) (4, 1) (6, 0)

        System.out.println("Is Empty: " + pq.isEmpty()); // Output: false
        System.out.println("Size: " + pq.size()); // Output: 3
    }
}
