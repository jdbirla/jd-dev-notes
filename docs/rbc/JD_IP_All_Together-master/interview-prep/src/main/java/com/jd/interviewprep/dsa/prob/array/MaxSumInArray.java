package com.jd.interviewprep.dsa.prob.array;

import java.util.Arrays;

public class MaxSumInArray {
	public static int maxSubarray(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		int maxSum = nums[0];
		int currentSum = nums[0];

		for (int i = 1; i < nums.length; i++) {
			currentSum = Math.max(nums[i], currentSum + nums[i]);
			maxSum = Math.max(maxSum, currentSum);
		}

		return maxSum;
	}

	public static void main(String[] args) {
		int[] inputCase1 = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int result1 = maxSubarray(inputCase1);
		System.out.println("Example 1: Input: " + Arrays.toString(inputCase1) + "\nResult: " + result1);

	}
}
