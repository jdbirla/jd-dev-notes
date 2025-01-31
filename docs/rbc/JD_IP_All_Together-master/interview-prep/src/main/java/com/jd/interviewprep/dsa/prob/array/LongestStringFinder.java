package com.jd.interviewprep.dsa.prob.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class LongestStringFinder {
	public static String findLongestString(String[] strings) {
		if (strings == null || strings.length == 0) {
			return null; // or throw an exception, depending on your requirements
		}

		// Use Arrays.stream to create a stream of strings, find the max based on length
		// Optional<String> result = Arrays.stream(strings).max((s1, s2) ->
		// Integer.compare(s1.length(), s2.length()));
		Optional<String> result = Arrays.stream(strings).sorted(Comparator.comparing(String::length).reversed())
				.findFirst();

		// Return the result or a default value if the array is empty
		return result.orElse(null);
	}

	public static void main(String[] args) {
		String[] strings = { "apple", "banana", "orange", "grapefruit", "kiwi", "pear" };

		System.out.println("Original array: " + Arrays.toString(strings));

		String longestString = findLongestString(strings);

		System.out.println("Longest string: " + longestString);
	}
}
