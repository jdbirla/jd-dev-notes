package com.jd.interviewprep.dsa.prob.string;

public class AddStrings {

	public static void main(String[] args) {
		try {
			// Example 1
			String num1 = "11";
			String num2 = "123";
			System.out.println("Example 1 Output: " + addStrings(num1, num2));

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

	public static String addStrings(String num1, String num2) {
		// Remove commas from the input strings
		num1 = num1.replaceAll(",", "");
		num2 = num2.replaceAll(",", "");

		StringBuilder result = new StringBuilder();

		int carry = 0;
		int i = num1.length() - 1;
		int j = num2.length() - 1;

		while (i >= 0 || j >= 0 || carry > 0) {
			// int digit1 = (i >= 0) ? num1.charAt(i--) - '0' : 0;
			// int digit2 = (j >= 0) ? num2.charAt(j--) - '0' : 0;
			int digit1 = (i >= 0) ? Integer.parseInt(String.valueOf(num1.charAt(i--))) : 0;
			int digit2 = (j >= 0) ? Integer.parseInt(String.valueOf(num2.charAt(j--))) : 0;
			int sum = digit1 + digit2 + carry;
			carry = sum / 10;
			result.insert(0, sum % 10);
		}

		// Insert commas back into the result string
		for (int k = result.length() - 2; k > 0; k -= 2) {
			result.insert(k, ',');
		}

		return result.toString();

	}
}
