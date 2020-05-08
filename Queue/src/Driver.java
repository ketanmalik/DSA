
public class Driver {
	public static void main(String[] args) {
		Queue<Integer> obj = new Queue<Integer>();

		// Enqueue operations
		System.out.println("Performing Enqueue Operations:");
		obj.enqueue(1);
		obj.enqueue(2);
		obj.enqueue(3);
		obj.enqueue(4);
		obj.enqueue(5);

		System.out.println();

		// Pop Operations
		System.out.println("Performing Dequeue Operations:");
		System.out.println("Item Popped: " + obj.dequeue().toString());
		System.out.println("Item Popped: " + obj.dequeue().toString());
		System.out.println("Item Popped: " + obj.dequeue().toString());
		System.out.println("Item Popped: " + obj.dequeue().toString());
		System.out.println("Item Popped: " + obj.dequeue().toString());

		System.out.println();

		// Multiple Push & Pop
		System.out.println("Performing multiple enqueue & dequeue operations:");
		obj.enqueue(1);
		obj.enqueue(2);
		System.out.println("Item Dequeued: " + obj.dequeue().toString());

		System.out.println();
		System.out.println("Current Queue:");
		obj.printQueue();
		System.out.println();

		obj.enqueue(3);
		obj.enqueue(4);
		obj.enqueue(5);
		System.out.println("Item Dequeued: " + obj.dequeue().toString());
		System.out.println();

		System.out.println();
		System.out.println("Current Queue:");
		obj.printQueue();
		System.out.println();

		// Peek
		System.out.println("Peek of the Queue: " + obj.peek().toString());
	}
}
