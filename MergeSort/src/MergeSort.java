import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		int[] A = { 7, 6, 2, 9, 5, 4, 2, 8, 10 };
		mergeSort(A, 0, A.length - 1);
		System.out.println(Arrays.toString(A));
	}

	public static void mergeSort(int[] A, int low, int high) {
		if (low == high)
			return;
		int mid = (low + high) / 2;
		mergeSort(A, low, mid);
		mergeSort(A, mid + 1, high);
		merge(A, low, mid, high);
	}

	public static void merge(int[] A, int low, int mid, int high) {
		int[] res = new int[(high - low) + 1];
		int i = low, j = mid + 1, k = 0;
		while (i <= mid && j <= high) {
			if (A[i] < A[j]) {
				res[k] = A[i];
				i++;
			} else {
				res[k] = A[j];
				j++;
			}
			k++;
		}
		for (; i <= mid; i++)
			res[k++] = A[i];
		for (; j <= high; j++)
			res[k++] = A[j];

		for (k = 0; k < res.length; k++)
			A[low++] = res[k];

	}
}
