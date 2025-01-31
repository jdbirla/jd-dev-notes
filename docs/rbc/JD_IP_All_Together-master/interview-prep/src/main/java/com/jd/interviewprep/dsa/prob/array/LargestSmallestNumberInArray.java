package com.jd.interviewprep.dsa.prob.array;

import java.util.Arrays;

public class LargestSmallestNumberInArray {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] { 12, 56, 76, 89, 100, 343, 21, 234 };

		// Using Stream
		int max = Arrays.stream(arr).max().getAsInt();
		int min = Arrays.stream(arr).min().getAsInt();
		System.out.println(max + " " + min);
		System.out.println("-----------------------------");

		// array of 10 numbers
		int arr1[] = new int[] { 12, 56, 76, 89, 100, 343, 21, 234 };

		// assign first element of an array to largest and smallest
		int smallest = arr1[0];
		int largest = arr1[0];

		for (int i = 1; i < arr1.length; i++) {
			if (arr1[i] > largest)
				largest = arr1[i];
			else if (arr1[i] < smallest)
				smallest = arr1[i];

		}
		System.out.println("Smallest Number is : " + smallest);
		System.out.println("Largest Number is : " + largest);

	}
}
