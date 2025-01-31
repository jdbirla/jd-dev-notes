package com.jd.interviewprep.dsa.prob.array;

import java.util.Arrays;

public class RemoveElementFromArray {

	public static void main(String[] args) {

		int[] nums = { 3, 2, 2, 3, 4, 5, 2, 6 };
		System.out.println(Arrays.toString(nums));

		int element = 2;
		int[] removeElementUsingJava8 = removeElementUsingJava8(nums, element);
		System.out.println(Arrays.toString(removeElementUsingJava8));

		int[] removeElementUsing = removeElementTraditional(nums, element);
		System.out.println(Arrays.toString(removeElementUsing));
	}

	static int[] removeElementUsingJava8(int[] arr, int val) {
		int[] result = Arrays.stream(arr).filter(num -> num != val).toArray();
		return result;
	}

	static int[] removeElementTraditional(int[] nums, int elementToRemove) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != elementToRemove) {
				nums[count] = nums[i];
				count++;
			}
		}

		// Create a new array with the correct size
		int[] newArray = Arrays.copyOf(nums, count);

		return newArray;
	}
}
