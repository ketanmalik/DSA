import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class BinaryMapHeap<T extends Comparable<T>> {

	// List to store elements of the heap
	private List<T> heapElems;
	private Map<T, TreeSet<Integer>> heapMap;

	BinaryMapHeap() {
		heapElems = new ArrayList<T>();
		heapMap = new HashMap<>();
	}

	public void add(T elem) {
		if (elem == null)
			throw new IllegalArgumentException();
		heapElems.add(elem);
		addToMap(elem, heapElems.size() - 1);
		bubbleUp(heapElems.size() - 1);
	}

	private void addToMap(T elem, int index) {
		if (heapMap.containsKey(elem)) {
			Set<Integer> set = heapMap.get(elem);
			set.add(index);
		} else {
			TreeSet<Integer> set = new TreeSet<>();
			set.add(index);
			heapMap.put(elem, set);
		}
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

	private void mapSwap(T node1, T node2, int x1, int x2) {
		TreeSet<Integer> s1 = heapMap.get(node1);
		TreeSet<Integer> s2 = heapMap.get(node2);
		s1.remove(x1);
		s2.remove(x2);
		s1.add(x2);
		s2.add(x1);
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
		T node = heapElems.get(indexToRemove);
		swap(indexToRemove, heapElems.size() - 1);
		heapElems.remove(heapElems.size() - 1);
		removeFromMap(node, heapElems.size());

		try {
			int index = (2 * indexToRemove) + 1;
			heapElems.get(index);
			bubbleDown(indexToRemove);
		} catch (Exception e) {
			bubbleUp(indexToRemove);
		}
	}

	private void removeFromMap(T elem, int index) {
		TreeSet<Integer> set = heapMap.get(elem);
		set.remove(index);
		if (set.size() == 0)
			heapMap.remove(elem);
	}

	public int size() {
		return heapElems.size();
	}

	private void swap(int x, int y) {
		T node1 = heapElems.get(x);
		T node2 = heapElems.get(y);
		heapElems.set(x, node2);
		heapElems.set(y, node1);
		mapSwap(node1, node2, x, y);
	}
}
