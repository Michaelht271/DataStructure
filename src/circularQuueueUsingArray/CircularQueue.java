package circularQuueueUsingArray;

class CircularQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] queueArray;
    private int size;

    public CircularQueue(int size) {
        this.maxSize = size;
        this.queueArray = new int[maxSize];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    // Enqueue: add an element to the end of the queue
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            rear = (rear + 1) % maxSize;
            queueArray[rear] = value;
            size++;
        }
    }

    // Dequeue: remove and return the front element of the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            int temp = queueArray[front];
            front = (front + 1) % maxSize;
            size--;
            return temp;
        }
    }

    // Peek: get the front element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            return queueArray[front];
        }
    }

    // IsEmpty: check if the queue is empty
    public boolean isEmpty() {
        return (size == 0);
    }

    // IsFull: check if the queue is full
    public boolean isFull() {
        return (size == maxSize);
    }

    // Size: get the current size of the queue
    public int size() {
        return size;
    }

    // Display: print all elements in the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        int temp = front;
        for (int i = 0; i < size; i++) {
            System.out.print(queueArray[temp] + " ");
            temp = (temp + 1) % maxSize;
        }
        System.out.println();
    }
}
