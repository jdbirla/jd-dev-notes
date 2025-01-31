package com.jd.interviewprep.dsa.prob.string;

import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class RemoveDuplicateCharactersInString {
	public static void main(String[] args) {
		String inputString = "programming";
		System.out.println("Original String: " + inputString);

		String removeDuplicateCharactersJava8 = removeDuplicateCharactersJava8(inputString);
		System.out.println("String without duplicate characters: " + removeDuplicateCharactersJava8);
		String removeDuplicateCharacters = removeDuplicateCharactersTraditional(inputString);
		System.out.println("String without duplicate characters: " + removeDuplicateCharacters);
	}

	public static String removeDuplicateCharactersJava8(String str) {

		String resultString = str.chars().distinct().mapToObj(c -> String.valueOf((char) c))
				.collect(Collectors.joining());
		return resultString;

	}

	public static String removeDuplicateCharactersTraditional(String str) {

		char[] charArray = str.toCharArray();
		LinkedHashSet<Character> uniqueChars = new LinkedHashSet<>();

		for (char c : charArray) {
			uniqueChars.add(c);
		}

		StringBuilder resultStringBuilder = new StringBuilder();
		for (Character c : uniqueChars) {
			resultStringBuilder.append(c);
		}

		return resultStringBuilder.toString();

	}
}
