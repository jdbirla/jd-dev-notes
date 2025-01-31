package com.jd.interviewprep.dsa.prob.string;

import java.util.Arrays;

public class StringAnagram {
	public static void main(String[] args) {

		String word = "java2blog";
		String anagram = "aj2vabgol";

		System.out.println("java2blog and aj2vabgol are anagrams :" + isAnagramUsingStringMethods(word, anagram));
		System.out.println("java2blog and aj2vabgol are anagrams using sort:" + isAnagramUsingArraySort(word, anagram));

	}

	public static boolean isAnagramUsingStringMethods(String word, String anagram) {
		if (word.length() != anagram.length())
			return false;

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			int index = anagram.indexOf(c);
			// If index of any character is -1, then two strings are not anagrams
			// If index of character is not equal to -1, then remove the chacter from the
			// String
			if (index != -1) {
				anagram = anagram.substring(0, index) + anagram.substring(index + 1, anagram.length());
			} else
				return false;
		}
		return anagram.isEmpty();
	}

	public static boolean isAnagramUsingArraySort(String word, String anagram) {

		if (word.length() != anagram.length()) {
			return false;
		}

		char[] charArray1 = word.toCharArray();
		char[] charArray2 = anagram.toCharArray();
		Arrays.sort(charArray1);
		Arrays.sort(charArray2);
		return Arrays.equals(charArray1, charArray2);
	}
}
