package com.jd.interviewprep.dsa.prob;

public class BinaryOperationProblem {

	public static void main(String[] args) {
		int solution = solution("0000011100");
		System.out.println(solution);
	}

	public static int solution(String S) {
		// convert the binary string to a long value
		long numberLong = Long.parseLong(S, 2);
		System.out.println(numberLong);
		// initialize the number of operations to zero
		int count = 0;
		// loop until V becomes zero
		while (numberLong > 0) {
			// if V is odd, subtract 1 from it
			if (numberLong % 2 == 1) {
				numberLong--;
			}
			// else if V is even, divide it by 2
			else {
				numberLong /= 2;
			}
			// increment the number of operations
			count++;
		}
		// return the number of operations
		return count;
	}
}