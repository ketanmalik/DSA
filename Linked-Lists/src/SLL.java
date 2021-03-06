public class SLL<T> {

	// Private inner class for a Node
	private class Node<T> {
		private T data;
		private Node<T> next;

		Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}

		@Override
		public String toString() {
			return this.data.toString();
		}
	}

	Node<T> head;
	Node<T> tail;
	int size;

	SLL() {
		head = tail = null;
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	// Add an element at the end of the linked list, O(1)
	public void add(T elem) {
		Node<T> node = addLast(elem);
	}

	// Add a node at the end of the linked list, O(1)
	public Node<T> addLast(T elem) {

		Node<T> node = new Node<T>(elem, null);
		if (isEmpty()) {
			head = tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
		size++;
		return node;
	}

	// Add a node at the start of the linked list, O(1)
	public Node<T> addFirst(T elem) {
		Node<T> node = new Node(elem, null);
		if (isEmpty()) {
			head = tail = node;
		} else {
			node.next = head;
			head = node;
		}
		size++;
		return node;
	}

	// Remove a node from the end of the linked list, O(n)
	public T removeEnd() {
		if (isEmpty())
			throw new RuntimeException("Linked List is empty");
		T data = tail.data;
		tail.data = null;
		--size;
		if (isEmpty()) {
			head = tail = null;
		} else {
			tail = head;
			for (int i = 1; i < size; i++) {
				tail = tail.next;
			}
			tail.next = null;
		}		
		return data;
	}

	// Remove a node from the start of the linked list, O(1)
	public T removeStart() {
		if (isEmpty())
			throw new RuntimeException("Linked List is empty");
		T data = head.data;
		head.data = null;
		--size;
		if (isEmpty()) {
			head = tail = null;
		} else {
			head = head.next;
		}

		return data;
	}

	// Remove a particular node from the linked list, O(n)
	public boolean removeNode(Node<T> node) {
		if (isEmpty())
			throw new RuntimeException("Linked List is empty");

		if (node.next == null) {
			removeEnd();
			return true;
		}

		if (size == 1) {
			removeStart();
			return true;
		}

		Node<T> trav1 = head;
		Node<T> trav2 = trav1.next;
		while (trav2 != null) {
			if (trav2 == node)
				break;
			trav2 = trav2.next;
			trav1 = trav1.next;
		}
		if (trav2 == null) {
			return false;
		}
		trav1.next = trav2.next;
		trav2.data = null;
		trav2.next = null;

		return true;
	}

	public void printLL() {
		if (isEmpty()) {
			System.out.println("Linked List is empty");
		} else {
			Node<T> trav = head;
			while (trav != null) {
				System.out.println(trav);
				trav = trav.next;
			}
		}
	}
}