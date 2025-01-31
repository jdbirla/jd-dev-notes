package com.jd.interviewprep.dsa.prob.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindAllDuplicateNumbers {
	public static void main(String[] args) {
		Integer[] array = { 1, 2, 3, 2, 4, 3, 5, 6, 5, 7, 8, 8, 9 };

		// 1
		Map<Integer, Integer> map = new HashMap<>();

		Map<Integer, Long> collect = Arrays.stream(array)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		List<Integer> collect2 = collect.entrySet().stream().filter(e -> e.getValue() > 1).map(e -> e.getKey())
				.collect(Collectors.toList());

		System.out.println(collect2);
	}
}
