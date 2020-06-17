
public class Driver {

	public static void main(String[] args) {

		BinaryListHeap<Integer> heap = new BinaryListHeap<Integer>();

		heap.add(1);
		heap.add(5);
		heap.add(1);
		heap.add(8);
		heap.add(6);
		heap.add(2);
		heap.add(2);
		heap.add(13);
		heap.add(12);
		heap.add(11);
		heap.add(7);
		heap.add(2);
		heap.add(15);
		heap.add(3);
		heap.add(10);

		heap.print();

		heap.poll();

		heap.print();

	}

}
