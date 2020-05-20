
public class Driver {
	public static void main(String[] args) {
		int[] parentArray1 = { 13, -3, 10, -12, -3 };
		int[] parentArray2 = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
		int[] parentArray3 = { -1, -3, -10, -12, -3 };
		int[] parentArray4 = { 1, 3, 10, 12, 3 };

		System.out.println(MaxSubArray.findMaximumSubArray(parentArray1, 0, parentArray1.length - 1));
		System.out.println(MaxSubArray.bruteForceSubArray(parentArray1));

		System.out.println();

		System.out.println(MaxSubArray.findMaximumSubArray(parentArray2, 0, parentArray2.length - 1));
		System.out.println(MaxSubArray.bruteForceSubArray(parentArray2));

		System.out.println();

		System.out.println(MaxSubArray.findMaximumSubArray(parentArray3, 0, parentArray3.length - 1));
		System.out.println(MaxSubArray.bruteForceSubArray(parentArray3));

		System.out.println();

		System.out.println(MaxSubArray.findMaximumSubArray(parentArray4, 0, parentArray4.length - 1));
		System.out.println(MaxSubArray.bruteForceSubArray(parentArray4));
	}
}
