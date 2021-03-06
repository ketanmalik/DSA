class Driver {
	public static void main(String args[]) {
		SLL<Integer> obj = new SLL<>();
		obj.add(1);
		obj.add(2);
		obj.add(3);
		obj.add(4);
		obj.add(5);
		
		System.out.println("Initial Linked List: ");
		obj.printLL();
		System.out.println();
		
		obj.addFirst(0);
		
		System.out.println("Adding 0 at beginning: ");
		obj.printLL();
		System.out.println();
		
		// Removing starting node
		obj.removeStart();
		System.out.println("Removing from beginning: ");
		obj.printLL();
		System.out.println();
		
		// Removing ending node
		obj.removeEnd();
		System.out.println("Removing from end: ");
		obj.printLL();
		System.out.println();
		
	}
}