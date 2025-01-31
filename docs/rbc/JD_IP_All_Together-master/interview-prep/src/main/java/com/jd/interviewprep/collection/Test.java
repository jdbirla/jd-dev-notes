package com.jd.interviewprep.collection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {

		int[] array1 = { 1, 2, 3, 4, 5 };
		int[] array2 = { 3, 4, 5, 6, 7 };

		List<Integer> commonValues = findCommonValues(array1, array2);

		System.out.println("Common Values: " + commonValues);
	}

	public static List<Integer> findCommonValues(int[] array1, int[] array2) {
		return Arrays.stream(array1).boxed().distinct()
				.filter(Arrays.stream(array2).boxed().collect(Collectors.toList())::contains)
				.collect(Collectors.toList());
	}
	
	
}
