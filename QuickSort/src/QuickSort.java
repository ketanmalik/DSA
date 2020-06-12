import java.util.Arrays;
import java.util.Random;

class QuickSort {

	public static void main(String[] args) {
		int[] arr = new int[2000];
		Random r = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt(9) * 10;
		}
		sortColors(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void sortColors(int[] nums) {
		long startTime = System.currentTimeMillis();
		quickSortStart(nums, 0, nums.length - 1);
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
		System.out.println("Time taken if pivot is at start: " + elapsedTime);

		startTime = System.currentTimeMillis();
		quickSortMid(nums, 0, nums.length - 1);
		endTime = System.currentTimeMillis();
		elapsedTime = endTime - startTime;
		System.out.println("Time taken if pivot is at mid: " + elapsedTime);
	}

	public static void quickSortStart(int[] arr, int lo, int hi) {
		if (lo >= hi)
			return;
		int j = partitionStart(arr, lo, hi);
		quickSortStart(arr, lo, j - 1);
		quickSortStart(arr, j + 1, hi);
	}

	public static void quickSortMid(int[] arr, int lo, int hi) {
		if (lo >= hi)
			return;
		int j = partitionMid(arr, lo, hi);
		quickSortMid(arr, lo, j - 1);
		quickSortMid(arr, j + 1, hi);
	}

	public static int partitionStart(int[] arr, int lo, int hi) {
		int i = lo, j = hi + 1;
		int pivot = arr[lo];
		while (true) {
			while (arr[++i] < pivot) {
				if (i == hi)
					break;
			}
			while (arr[--j] >= pivot) {
				if (j == lo)
					break;
			}
			if (i >= j)
				break;
			swap(arr, i, j);
		}
		swap(arr, lo, j);
		return j;
	}

	public static int partitionMid(int[] arr, int lo, int hi) {
		int mid = (lo + hi) / 2;
		swap(arr, lo, mid);
		int i = lo, j = hi + 1;
		int pivot = arr[lo];
		while (true) {
			while (arr[++i] < pivot) {
				if (i == hi)
					break;
			}
			while (arr[--j] >= pivot) {
				if (j == lo)
					break;
			}
			if (i >= j)
				break;
			swap(arr, i, j);
		}
		swap(arr, lo, j);
		return j;
	}

	public static void swap(int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
}