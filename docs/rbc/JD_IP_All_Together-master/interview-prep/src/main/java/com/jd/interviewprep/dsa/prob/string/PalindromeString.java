package com.jd.interviewprep.dsa.prob.string;

public class PalindromeString {

	public static void main(String[] args) {
		// String str = "madam"; // Example string
		String str = "A man, a plan, a canal, Panama";

		if (isPalindrome(str)) {
			System.out.println(str + " is a palindrome.");
		} else {
			System.out.println(str + " is not a palindrome.");
		}

		if (isPalindromeUsingStringBuilder(str)) {
			System.out.println(str + " is a palindrome.");
		} else {
			System.out.println(str + " is not a palindrome.");
		}

		if (isPalindromeString(str)) {
			System.out.println(str + " is a palindrome.");
		} else {
			System.out.println(str + " is not a palindrome.");
		}

	}

	public static Boolean isPalindrome(String input) {
		input = input.toLowerCase().replaceAll("[^a-z0-9]", "");
		int length = input.length();
		for (int i = 0; i < length / 2; i++) {
			if (input.charAt(i) != input.charAt(length - 1 - i)) {
				return false;
			}
		}
		return true;

	}

	public static Boolean isPalindromeUsingStringBuilder(String input) {
		input = input.toLowerCase().replaceAll("[^a-z0-9]", "");

		String reversed = new StringBuilder(input).reverse().toString();
		boolean isPalindrome = input.equalsIgnoreCase(reversed); // prints 'true'
		return isPalindrome;

	}

	public static boolean isPalindromeString(String str) {
		str = str.toLowerCase().replaceAll("[^a-z0-9]", "");
		int start = 0, end = str.length() - 1;
		while (start < end) {
			if (str.charAt(start) != str.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}
