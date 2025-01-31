package com.jd.interviewprep.java8;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {
	public static void main(String[] args) {
		String str = "jitendra birla";

		Map<Character, Long> charFrequencyMap = str.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		// Print duplicate characters
		System.out.println("Duplicate characters in the string:");
		charFrequencyMap.entrySet().stream().filter(entry -> entry.getValue() > 1)
				.forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));
	}
}
