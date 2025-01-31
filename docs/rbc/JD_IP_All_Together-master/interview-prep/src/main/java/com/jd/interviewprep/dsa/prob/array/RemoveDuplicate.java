package com.jd.interviewprep.dsa.prob.array;

import java.util.Arrays;

public class RemoveDuplicate {
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 3, 2, 5, 6, 7, 8, 1 };

		int[] removeDuplicatesUsingStream = removeDuplicatesUsingStream(array);
		System.out.println(Arrays.toString(removeDuplicatesUsingStream));

		int[] removeDuplicatesUsingStream1 = removeDuplicates(array);
		System.out.println(Arrays.toString(removeDuplicatesUsingStream1));

	}

	private static int[] removeDuplicatesUsingStream(int[] array) {
		// Use IntStream to create a stream of distinct values
		int[] distinctArray = Arrays.stream(array).distinct().toArray();
		return distinctArray;
	}

	private static int[] removeDuplicates(int[] array) {
		int n = array.length;

		// Check for empty or single element array
		if (n <= 1) {
			return array;
		}

		// Sorting the array
		Arrays.sort(array);

		// Counting duplicates
		int count = 0;
		for (int i = 1; i < n; i++) {
			if (array[i] != array[count]) {
				count++;
				array[count] = array[i];
			}
		}

		// Creating a new array with distinct elements
		int[] distinctArray = Arrays.copyOf(array, count + 1);

		return distinctArray;
	}

}
