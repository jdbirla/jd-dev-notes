package com.jd.interviewprep.dsa.prob;

public class FabonacciNumber {

	public static void main(String[] args) {
		System.out.println("using Array : ");
		usingArray(10);
		System.out.println("using Loop : ");
		usingLoop(10);
		System.out.println("using Recursion : ");
		usingRecursion(10);
	}

	/**
	 * @param num
	 */
	/**
	 * @param num
	 */
	public static void usingArray(int num) {
		int count = num; // Number of Fibonacci numbers to generate

		System.out.println("Fibonacci Sequence of " + count + " numbers:");

		int[] fibonacciNumbers = new int[count];
		fibonacciNumbers[0] = 0; // First Fibonacci number
		fibonacciNumbers[1] = 1; // Second Fibonacci number

		// Generate Fibonacci sequence
		for (int i = 2; i < count; i++) {
			fibonacciNumbers[i] = fibonacciNumbers[i - 1] + fibonacciNumbers[i - 2];
		}

		// Print Fibonacci sequence
		for (int number : fibonacciNumbers) {
			System.out.print(number + " ");
		}
	}

	public static void usingLoop(int n) {
		int firstTerm = 0, secondTerm = 1;
		System.out.print("Fibonacci Series of " + n + " terms:\n");

		for (int i = 1; i <= n; i++) {
			System.out.print(firstTerm + " ");

			int nextTerm = firstTerm + secondTerm;
			firstTerm = secondTerm;
			secondTerm = nextTerm;
		}
	}

	public static void usingRecursion(int count) {

		System.out.println("Fibonacci Sequence of " + count + " numbers:");

		// Generate and print Fibonacci sequence
		for (int i = 0; i < count; i++) {
			System.out.print(fibonacci(i) + " ");
		}
	}

	public static int fibonacci(int n) {
		if (n <= 1) {
			return n;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

}
