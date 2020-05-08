
public class DynamicArray {
	int[] staticArray;
	int capacity = 2;
	int length = 0;

	DynamicArray() {
		staticArray = new int[this.capacity];
	}

	void add(int x) {
		if (length >= capacity) {
			capacity = 2 * capacity;
			int[] newArr = new int[capacity];
			for (int i = 0; i < staticArray.length; i++) {
				newArr[i] = staticArray[i];
			}
			staticArray = newArr;

		}
		staticArray[length++] = x;
	}

	void delete() {
		if (length == capacity / 4) {
			capacity = capacity / 2;
			int[] newArr = new int[capacity];
			for (int i = 0; i < newArr.length; i++) {
				newArr[i] = staticArray[i];
			}
			staticArray = newArr;
		}
		staticArray[--length] = 0;
	}

	public static void main(String args[]) {
		DynamicArray obj = new DynamicArray();
		obj.add(1);
		obj.add(2);
		obj.add(3);
		obj.add(4);
		obj.add(5);
		obj.delete();
		obj.delete();
		obj.delete();
		obj.delete();
		System.out.println();
	}
}
