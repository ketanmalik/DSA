import java.util.ArrayList;
import java.util.List;

/**
 * The following class implements Priority Queue using Binary Heap. List is used
 * to keep track of elements inside the heap. Due to list, remove() method takes
 * O(n) time. It can be reduced to O(logn) using Hashtable (implemented in BinaryMapHeap)
 * 
 * Supported Operations:
 * 	1. Add - O(logn)
 * 	2. Remove - O(n)
 * 	3. Poll - O()
 * 	4. Peek - O(1)
 * 	5. Contains - O(n)
 * 	6. GetIndex - O(n)
 */

public class BinaryListHeap<T extends Comparable<T>> {

	// List to store elements of the heap
	private List<T> heapElems;

	BinaryListHeap() {
		heapElems = new ArrayList<T>();
	}

	public void add(T elem) {
		if (elem == null)
			throw new IllegalArgumentException();
		heapElems.add(elem);
		bubbleUp(heapElems.size() - 1);
	}

	private void bubbleDown(int parentIndex) {
		int leftChild = (2 * parentIndex) + 1;
		int rightChild = (2 * parentIndex) + 2;
		int childToReplace = leftChild;

		if (less(rightChild, leftChild))
			childToReplace = rightChild;

		while (parentIndex < heapElems.size() && less(childToReplace, parentIndex)) {
			swap(parentIndex, childToReplace);
			parentIndex = childToReplace;
			childToReplace = Math.min((2 * parentIndex + 1), (2 * parentIndex + 2));
		}
	}

	private void bubbleUp(int childIndex) {
		int parentIndex = (childIndex - 1) / 2;
		while (childIndex > 0 && less(childIndex, parentIndex)) {
			swap(childIndex, parentIndex);
			childIndex = parentIndex;
			parentIndex = (childIndex - 1) / 2;
		}
	}

	public void clear() {
		heapElems.clear();
		System.out.println("Heap Cleared");
	}

	public boolean contains(T elem) {
		if (elem == null)
			return false;
		return heapElems.contains(elem);
	}

	public boolean isEmpty() {
		return heapElems.isEmpty();
	}

	public int getIndex(T elem) {
		if (elem == null)
			throw new IllegalArgumentException();
		for (int i = 0; i < heapElems.size(); i++) {
			if (heapElems.get(i) == elem)
				return i;
		}
		return -1;
	}

	public boolean less(int x, int y) {
		T node1 = heapElems.get(x);
		T node2 = heapElems.get(y);
		return node1.compareTo(node2) <= 0;
	}

	public T peek() {
		if (heapElems.isEmpty())
			return null;
		return heapElems.get(0);
	}

	public T poll() {
		T elem = heapElems.get(0);
		removeAt(0);
		return elem;
	}

	public void print() {
		System.out.println(heapElems.toString());
	}

	public void remove(T elem) {
		if (elem == null)
			throw new IllegalArgumentException();
		int indexToRemove = getIndex(elem);
		if (indexToRemove == -1) {
			System.out.println("Element does not exist in the heap");
			return;
		}
		removeAt(indexToRemove);

	}

	private void removeAt(int indexToRemove) {
		swap(indexToRemove, heapElems.size() - 1);
		heapElems.remove(heapElems.size() - 1);
		try {
			int index = (2 * indexToRemove) + 1;
			heapElems.get(index);
			bubbleDown(indexToRemove);
		} catch (Exception e) {
			bubbleUp(indexToRemove);
		}
	}

	public int size() {
		return heapElems.size();
	}

	private void swap(int x, int y) {
		T node1 = heapElems.get(x);
		T node2 = heapElems.get(y);
		heapElems.set(x, node2);
		heapElems.set(y, node1);
	}

}
