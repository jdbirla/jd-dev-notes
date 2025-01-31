package com.jd.interviewprep.dsa.prob.string;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class GetFirstNonRepeatingCharacter {
	public static void main(String[] args) {
		System.out
				.println("First non repeated character for String analogy is : " + getNonRepeatedCharacter("analogy"));
		System.out
				.println("First non repeated character for String easiest is : " + getNonRepeatedCharacter("eaesiest"));
		System.out.println(
				"First non repeated character for String easiest is : " + getNonRepeatedCharacterJava8("eaesiest"));
	}

	public static Character getNonRepeatedCharacter(String str) {
		Map<Character, Integer> countCharacters = new LinkedHashMap<Character, Integer>();
		for (int i = 0; i < str.length() - 1; i++) {
			Character c = str.charAt(i);
			if (!countCharacters.containsKey(c)) {
				countCharacters.put(c, 1);
			} else {
				countCharacters.put(c, countCharacters.get(c) + 1);
			}
		}
		// As LinkedHashMap maintains insertion order, first character with
		// count 1 should return first non repeated character
		for (Entry<Character, Integer> e : countCharacters.entrySet()) {
			if (e.getValue() == 1)
				return e.getKey();

		}
		return null;

	}

	public static Character getNonRepeatedCharacterJava8(String str) {
		List<Character> charList = str.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

		return charList.stream().collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(entry -> entry.getValue() == 1).map(Map.Entry::getKey).findFirst()
				.orElse('\0'); // Default

	}
}
