
public class Driver {

	public static void main(String[] args) {

		BinaryMapHeap<Integer> heap = new BinaryMapHeap<Integer>();

		heap.add(2);
		heap.add(3);
		heap.add(2);
		heap.add(7);
		heap.add(7);
		heap.add(13);
		heap.add(11);

		heap.print();

		heap.poll();

		heap.print();

	}

}
