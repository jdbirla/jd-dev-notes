package com.jd.interviewprep.dsa.prob.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OddTimesElementInArray {
	public static void main(String[] args) {
		int array[] = new int[] { 20, 40, 50, 40, 50, 20, 30, 30, 50, 20, 40, 40, 20 };

		System.out.println("getOddTimesElementHashing :" + getOddTimesElementHashing(array));
		System.out.println("Get odd time lelemt in array uding stream :" + getOddTimesElementUsingStream(array));

	}

	public static int getOddTimesElementHashing(int ar[]) {
		int i;

		HashMap<Integer, Integer> elements = new HashMap<Integer, Integer>();
		for (i = 0; i < ar.length; i++) {
			int element = ar[i];
			if (elements.get(element) == null) {
				elements.put(element, 1);

			} else
				elements.put(element, elements.get(element) + 1);
		}
		for (Entry<Integer, Integer> entry : elements.entrySet()) {
			if (entry.getValue() % 2 == 1) {
				return entry.getKey();
			}

		}
		return -1;
	}

	public static int getOddTimesElementUsingStream(int arr[]) {

		Integer key = Arrays.stream(arr).boxed()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(e -> e.getValue() % 2 != 0).findFirst().get().getKey();

		return key;
	}

}
