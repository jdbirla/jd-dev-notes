package com.jd.interviewprep.dsa.prob.array;

public class FindPairWithMinSum {

	public static void main(String[] args) {

		int array[] = { 1, 30, -5, 70, -8, 20, -40, 60 };
		findPairWithMinSumBruteForce(array);
		findPairWithClosestToXBruteForce(array, 31);
	}

	public static void findPairWithMinSumBruteForce(int arr[]) {
		if (arr.length < 2)
			return;
		// Suppose 1st two element has minimum sum
		int minimumSum = arr[0] + arr[1];
		int pair1stIndex = 0;
		int pair2ndIndex = 1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int tempSum = arr[i] + arr[j];
				if (Math.abs(tempSum) < Math.abs(minimumSum)) {
					pair1stIndex = i;
					pair2ndIndex = j;
					minimumSum = tempSum;
				}
			}
		}
		System.out.println(" The pair whose sum is closest to zero : " + arr[pair1stIndex] + " " + arr[pair2ndIndex]);
	}

	public static void findPairWithClosestToXBruteForce(int arr[], int X) {
		if (arr.length < 2)
			return;
		// Suppose 1st two element has minimum diff with X
		int minimumDiff = Math.abs(arr[0] + arr[1] - X);
		int pair1stIndex = 0;
		int pair2ndIndex = 1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int tempDiff = Math.abs(arr[i] + arr[j] - X);

				if (tempDiff < minimumDiff) {
					pair1stIndex = i;
					pair2ndIndex = j;
					minimumDiff = tempDiff;
				}
			}
		}
		System.out.println(" The pair whose sum is closest to X using brute force method: " + arr[pair1stIndex] + " "
				+ arr[pair2ndIndex]);
	}

}