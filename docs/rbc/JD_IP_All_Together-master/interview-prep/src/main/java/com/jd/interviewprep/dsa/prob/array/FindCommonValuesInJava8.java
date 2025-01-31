package com.jd.interviewprep.dsa.prob.array;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindCommonValuesInJava8 {

	public static void main(String[] args) {
		int arr1[] = { 5, 7, 2, 8, 9 };
		int arr2[] = { 6, 10, 2, 8, 4 };

		System.out.println(" find comman value in two arrays :" + findCommonValues(arr1, arr2));
	}

	public static Set<Integer> findCommonValues(int arr1[], int arr2[]) {
		Set<Integer> set1 = Arrays.stream(arr1).boxed().collect(Collectors.toSet());
		Set<Integer> set2 = Arrays.stream(arr2).boxed().collect(Collectors.toSet());
		set1.retainAll(set2);

		return set1;

	}
	public static List<Integer> findCommonValuesUsingStream(int[] array1, int[] array2) {
		return Arrays.stream(array1).boxed().distinct()
				.filter(Arrays.stream(array2).boxed().collect(Collectors.toList())::contains)
				.collect(Collectors.toList());
	}
	
}