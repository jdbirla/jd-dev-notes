package com.jd.interviewprep.dsa.prob.string;

public class FibonacciWithCommas {

	public static void main(String[] args) {
		try {
			// Example 1
			String num1 = "11";
			String num2 = "123";
			System.out.println("Example 1 Output: " + addStrings(num1, num2));
			System.out.println("Example 1 Output: " + calculateFibonacci(Integer.parseInt(addStrings("5","2"))));
			// Example with commas
			num1 = "11,000";
			num2 = "123,456";
			System.out.println("Example with Commas Output: " + addStrings(num1, num2));

			// Example 3
			num1 = "0";
			num2 = "0";
			System.out.println("Example 3 Output: " + addStrings(num1, num2));
		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

    // Method to calculate the n'th Fibonacci number
    public static long calculateFibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        long fib = 1;
        long prev = 1;

        for (int i = 2; i < n; i++) {
            long temp = fib;
            fib += prev;
            prev = temp;
        }

        return fib;
    }

    // Method to add two numbers represented as strings with commas
    public static String addStrings(String num1, String num2) {
        num1 = num1.replaceAll(",", "");
        num2 = num2.replaceAll(",", "");

        StringBuilder result = new StringBuilder();

        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = (i >= 0) ? num1.charAt(i--) - '0' : 0;
            int digit2 = (j >= 0) ? num2.charAt(j--) - '0' : 0;

            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            result.insert(0, sum % 10);
        }

        for (int k = result.length() - 3; k > 0; k -= 3) {
            result.insert(k, ',');
        }

        return result.toString();
    }
}
