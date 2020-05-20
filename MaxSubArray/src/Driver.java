
public class Driver {
	public static void main(String[] args) {
		int[] parentArray = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
		System.out.println(MaxSubArray.findMaximumSubArray(parentArray, 0, parentArray.length - 1));
	}
}
