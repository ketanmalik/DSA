
public class Stack<T> {

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

	public Stack() {
		head = tail = null;
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public T peek() {
		if (isEmpty())
			throw new RuntimeException("Stack is currently empty");
		return head.data;
	}

	public void push(T elem) {
		addToHead(elem);
	}

	private void addToHead(T elem) {
		Node<T> node = new Node<T>(elem, head);
		head = node;
		if (size == 0)
			tail = node;
		size++;
		System.out.println("Item Pushed: " + elem);
	}

	public T pop() {
		if (isEmpty())
			throw new RuntimeException("Stack is currently empty");
		Node<T> temp = head;
		head = head.next;
		T data = temp.data;
		temp.data = null;
		temp.next = null;
		--size;
		return data;
	}

	public void printStack() {
		if (isEmpty())
			throw new RuntimeException("Stack is currently empty");
		Node<T> trav = head;
		while (trav != null) {
			System.out.println("Item: " + trav.data);
			trav = trav.next;
		}
	}

}
