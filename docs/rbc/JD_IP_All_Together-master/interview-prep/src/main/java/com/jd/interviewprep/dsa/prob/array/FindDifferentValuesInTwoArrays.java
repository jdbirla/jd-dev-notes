package com.jd.interviewprep.dsa.prob.array;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindDifferentValuesInTwoArrays {
	public static void main(String[] args) {
		Integer[] array1 = { 1, 2, 3, 4, 5 };
		Integer[] array2 = { 4, 5, 6, 7, 8,10,12 };

		Set<Integer> differentValues = 
				Stream.concat(Arrays.stream(array1), Arrays.stream(array2))
				.filter(x -> !Arrays.asList(array1).contains(x) || !Arrays.asList(array2).contains(x))
				.collect(Collectors.toSet());


		System.out.println(differentValues);
	}
}