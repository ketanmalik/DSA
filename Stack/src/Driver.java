
public class Driver {

	public static void main(String args[]) {
		Stack<Integer> obj = new Stack<>();

		// Push operations
		System.out.println("Performing Push Operations:");
		obj.push(1);
		obj.push(2);
		obj.push(3);
		obj.push(4);
		obj.push(5);

		System.out.println();

		// Pop Operations
		System.out.println("Performing Pop Operations:");
		System.out.println("Item Popped: " + obj.pop().toString());
		System.out.println("Item Popped: " + obj.pop().toString());
		System.out.println("Item Popped: " + obj.pop().toString());
		System.out.println("Item Popped: " + obj.pop().toString());
		System.out.println("Item Popped: " + obj.pop().toString());

		System.out.println();

		// Multiple Push & Pop
		System.out.println("Performing multiple push & pop operations:");
		obj.push(1);
		obj.push(2);
		System.out.println("Item Popped: " + obj.pop().toString());

		System.out.println();
		System.out.println("Current Stack:");
		obj.printStack();
		System.out.println();

		obj.push(3);
		obj.push(4);
		obj.push(5);
		System.out.println("Item Popped: " + obj.pop().toString());
		System.out.println();
		
		System.out.println();
		System.out.println("Current Stack:");
		obj.printStack();
		System.out.println();

		// Peek
		System.out.println("Peek of the stack: " + obj.peek().toString());

	}
}
