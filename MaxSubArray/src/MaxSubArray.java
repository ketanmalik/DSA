
/*
 * This problem focuses on finding a maximum sub-array, say SA[i...j], from an array, say A[low...high] which has the maximum sum. 
 * Divide and Conquer technique is used to find the solution.
 * 
 * Algorithm:
 * 		Start
 * 			FindMaximumSubArray(A, low, high)
 * 				if(high == low) return (low, high, A[low])
 * 				else
 * 					mid = (low + high) / 2
 * 					(left-low, left-high, left-sum) = FindMaximumSubArray(A, low, mid)
 * 					(right-low, right-high, right-sum) = FindMaximumSubArray(A, mid + 1, high)
 * 					(cross-low, cross-high, cross-sum) = FindMaxCrossingSubArray(A, low, mid, high)
 * 					if(left-sum >= right-sum and left-sum >= cross-sum)
 * 						return (left-low, left-high, left-sum)
 * 					else if(right-sum >= left-sum and right-sum >= cross-sum)
 * 						return (right-low, right-high, right-sum)
 * 					else return (cross-low, cross-high, cross-sum)
 * 				end else
 * 		Stop
 * 
 * @author ketanmalik
 * May 20 2020
 * 
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSubArray {

	public static List<Integer> findMaximumSubArray(int[] arr, int low, int high) {
		if (low == high) {
			return new ArrayList<Integer>(Arrays.asList(low, high, arr[low]));
		}
		int mid = (low + high) / 2;
		List<Integer> leftSA = findMaximumSubArray(arr, low, mid);
		List<Integer> rightSA = findMaximumSubArray(arr, mid + 1, high);
		List<Integer> crossSA = findMaxCrossSubArray(arr, low, mid, high);

		int leftLow = leftSA.get(0), leftHigh = leftSA.get(1), leftSum = leftSA.get(2);
		int rightLow = rightSA.get(0), rightHigh = rightSA.get(1), rightSum = rightSA.get(2);
		int crossLow = crossSA.get(0), crossHigh = crossSA.get(1), crossSum = crossSA.get(2);

		if (leftSum >= rightSum && leftSum >= crossSum)
			return new ArrayList<>(Arrays.asList(leftLow, leftHigh, leftSum));
		else if (rightSum >= leftSum && rightSum >= crossSum)
			return new ArrayList<>(Arrays.asList(rightLow, rightHigh, rightSum));

		return new ArrayList<>(Arrays.asList(crossLow, crossHigh, crossSum));
	}

	private static List<Integer> findMaxCrossSubArray(int[] arr, int low, int mid, int high) {
		int leftSum = arr[mid], sum = 0, leftIndex = mid;
		for (int i = mid; i >= low; i--) {
			sum += arr[i];
			if (sum > leftSum) {
				leftSum = sum;
				leftIndex = i;
			}
		}
		sum = 0;
		int rightSum = arr[mid+1], rightIndex = mid+1;
		for (int i = mid + 1; i <= high; i++) {
			sum += arr[i];
			if (sum >= rightSum) {
				rightSum = sum;
				rightIndex = i;
			}
		}
		return new ArrayList<>(Arrays.asList(leftIndex, rightIndex, leftSum + rightSum));
	}

}
