package doubleCircularLinkList;



class DoubleCircularLinkedList {
	Node head;

	// Insert a node at the end
	public void insert(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			head.next = head;
			head.prev = head;
		} else {
			Node tail = head.prev;
			tail.next = newNode;
			newNode.prev = tail;
			newNode.next = head;
			head.prev = newNode;
		}
	}

	// Delete a node from the list
	public void delete(int data) {
		if (head == null)
			return;
		Node current = head;
		do {
			if (current.data == data) {
				if (current.next == current) {
					head = null; // If it's the only node
				} else {
					Node nextNode = current.next;
					Node prevNode = current.prev;
					prevNode.next = nextNode;
					nextNode.prev = prevNode;
					if (current == head) {
						head = nextNode;
					}
				}
				return;
			}
			current = current.next;
		} while (current != head);
	}

	// Display the list
	public void display() {
		if (head == null)
			return;
		Node temp = head;
		do {
			System.out.print(temp.data + " ");
			temp = temp.next;
		} while (temp != head);
		System.out.println();
	}

	public int solveJosephusProblem(int n, int k) {
		DoubleCircularLinkedList list = new DoubleCircularLinkedList();

		for (int i = 1; i <= n; i++) {
			list.insert(i);
		}

		Node current = list.head;
		while (n > 1) {
			for (int count = 1; count < k; count++) {
				current = current.next;
			}
			Node next = current.next;
			list.delete(current.data);
			current = next;
			n--;
		}

		return current.data;
	}

	public void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


