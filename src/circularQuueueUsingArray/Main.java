package circularQuueueUsingArray;

public class Main {
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        
        queue.display(); // Output: 10 20 30 40 50

        System.out.println("Dequeue: " + queue.dequeue()); // Output: 10
        System.out.println("Peek: " + queue.peek()); // Output: 20

        queue.enqueue(60);
        queue.display(); // Output: 20 30 40 50 60

        System.out.println("Is Empty: " + queue.isEmpty()); // Output: false
        System.out.println("Is Full: " + queue.isFull()); // Output: true
        System.out.println("Size: " + queue.size()); // Output: 5
    }
}
