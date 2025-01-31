package com.jd.interviewprep.dsa.prob.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicateCharactersInString {
	public static void main(String[] args) {
		System.out.println(findDuplicatesUsingMaps("code decode")); // Time complexity = O(NLogn),
		System.out.println(findDuplicatesUsingStream("code decode")); // Time complexity = O(NLogn),
		System.out.println(findDuplicatesUsingStringStream("Jitendra birla")); // Time complexity = O(NLogn),
	}

	private static List<Character> findDuplicatesUsingStream(String name) {
		Map<Character, Long> collect = name.replaceAll("\\W", "").chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		List<Character> collect2 = collect.entrySet().stream().filter(entry -> entry.getValue() > 1)
				.map(e -> e.getKey()).collect(Collectors.toList());

		return collect2;
	}

	private static List<String> findDuplicatesUsingStringStream(String name) {
		String[] splitArr = name.replaceAll("\\W", "").split("");

		Map<String, Long> collect = Arrays.stream(splitArr)
				.collect(Collectors.groupingBy(s -> s, Collectors.counting()));

		List<String> collect2 = collect.entrySet().stream().filter(entry -> entry.getValue() > 1)
				.map(entry -> entry.getKey()).collect(Collectors.toList());

		return collect2;
	}

	private static Set<Character> findDuplicatesUsingMaps(String name) {

		Set<Character> duplicates = new LinkedHashSet<>();
		HashMap<Character, Integer> countMap = new HashMap<Character, Integer>();
		// code decode
		for (int i = 0; i < name.length(); i++) { // O(n)
			if (countMap.containsKey(name.charAt(i))) { // d
				countMap.put(name.charAt(i), countMap.get(name.charAt(i)) + 1); // d, 3 , e ,3 // O(logn)
			} else {
				countMap.put(name.charAt(i), 1); // code d,3
			}
		}
		for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
			if (entry.getValue() > 1)
				duplicates.add(entry.getKey());
		}
		return duplicates;
	}
}
