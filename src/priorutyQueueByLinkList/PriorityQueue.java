package priorutyQueueByLinkList;

class PriorityQueue {
    private Node head;

    // Enqueue: insert an element into the priority queue
    public void enqueue(int data, int priority) {
        Node newNode = new Node(data, priority);

        if (head == null || head.priority < priority) {
            newNode.next = head;
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null && temp.next.priority >= priority) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    // Dequeue: remove and return the element with the highest priority
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            int data = head.data;
            head = head.next;
            return data;
        }
    }

    // Peek: get the element with the highest priority without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            return head.data;
        }
    }

    // IsEmpty: check if the queue is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Size: get the current size of the queue
    public int size() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // Display: print all elements in the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print("(" + temp.data + ", " + temp.priority + ") ");
            temp = temp.next;
        }
        System.out.println();
    }
}
