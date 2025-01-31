package com.jd.interviewprep.dsa.prob.string;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "hello world";
		System.out.println(str);
		// using string builder

		System.out.println("StringBuilder : " + stringBuilder(str));
		System.out.println("usingLoop : " + usingLoop(str));
		System.out.println("reverseString : " + reverseString(str));
		System.out.println("reverseCharArray : " + reverseCharArray(str));

	}

	public static String stringBuilder(String str) {
		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		String reversedStr = sb.toString();
		return reversedStr;
	}

	public static String usingLoop(String str) {
		StringBuilder reversed = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; i--) {
			reversed.append(str.charAt(i));
		}
		String result = reversed.toString();
		return result;
	}

	// using recursion
	public static String reverseString(String str) {
		if (str.isEmpty()) {
			return str;
		}
		return reverseString(str.substring(1)) + str.charAt(0);

	}

	public static String reverseCharArray(String str) {

		char[] chars = str.toCharArray();
		int start = 0;
		int end = chars.length - 1;

		while (start < end) {
			// Swap characters at start and end indices
			char temp = chars[start];
			chars[start] = chars[end];
			chars[end] = temp;

			// Move the indices towards the center
			start++;
			end--;
		}

		return new String(chars);
	}
}
