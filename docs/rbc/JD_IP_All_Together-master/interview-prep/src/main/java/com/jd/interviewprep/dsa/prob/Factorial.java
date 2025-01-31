package com.jd.interviewprep.dsa.prob;

public class Factorial {
	public static void main(String[] args) {
		int number = 5; // Example number

		long factorial = calculateFactorialIterative(number);

		System.out.println("Factorial of " + number + " is: " + factorial);
		 factorial = calculateFactorialRecursive(number);

		System.out.println("Factorial of " + number + " is: " + factorial);
	}

	public static long calculateFactorialIterative(int number) {
		long factorial = 1;
		for (int i = 1; i <= number; i++) {
			factorial *= i;
		}
		return factorial;
	}

	public static long calculateFactorialRecursive(int number) {
		if (number <= 1) {
			return 1;
		} else {
			return number * calculateFactorialRecursive(number - 1);
		}
	}
}
