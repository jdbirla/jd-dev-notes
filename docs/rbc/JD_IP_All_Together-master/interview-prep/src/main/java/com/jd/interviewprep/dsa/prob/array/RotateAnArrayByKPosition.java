package com.jd.interviewprep.dsa.prob.array;

public class RotateAnArrayByKPosition {
	public static void main(String[] args) {
		int Array[] = { 1, 2, 3, 4, 5 };

		int K = 2;
		rightRotateBruteForce(Array, K);
		int Array1[] = { 1, 2, 3, 4, 5 };
		leftRotateBruteForce(Array1, K);

	}

	public static int[] rightRotateBruteForce(int[] nums, int k) {
		for (int i = 0; i < k; i++) {
			for (int j = nums.length - 1; j > 0; j--) {
				// move each number by 1 place
				int temp = nums[j];
				nums[j] = nums[j - 1];
				nums[j - 1] = temp;
			}
			System.out.println("Array Right rotation after " + (i + 1) + " step");
			printArray(nums);
			System.out.println();
		}
		return nums;
	}
	public static int[] leftRotateBruteForce(int[] nums, int k) {
		for (int i = 0; i < k; i++) {
			for (int j = 0 ; j <nums.length -1; j++) {
				// move each number by 1 place
				int temp = nums[j];
				nums[j] = nums[j + 1];
				nums[j + 1] = temp;
			}
			System.out.println("Array left rotation after " + (i + 1) + " step");
			printArray(nums);
			System.out.println();
		}
		return nums;
	}
	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}