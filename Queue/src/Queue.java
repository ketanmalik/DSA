
public class Queue<T> {

	private static class Node<T> {
		private T data;
		private Node<T> next;

		Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
	}

	Node<T> head;
	Node<T> tail;
	int size;

	public Queue() {
		head = tail = null;
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public T peek() {
		if (isEmpty())
			throw new RuntimeException("Queue is currently empty");
		return head.data;
	}

	public void enqueue(T elem) {
		Node<T> node = new Node<T>(elem, null);
		if (size == 0) {
			head = tail = node;
		}
		tail.next = node;
		tail = node;

		size++;
		System.out.println("Item Enqueued: " + elem);
	}

	public T dequeue() {
		if (isEmpty())
			throw new RuntimeException("Queue is currently empty");
		Node<T> temp = head;
		head = head.next;
		T data = temp.data;
		temp.data = null;
		temp.next = null;
		--size;
		return data;
	}

	public void printQueue() {
		if (isEmpty())
			throw new RuntimeException("Queue is currently empty");
		Node<T> trav = head;
		while (trav != null) {
			System.out.println("Item: " + trav.data);
			trav = trav.next;
		}
	}
}
