package com.jd.interviewprep.dsa.prob.array;

import java.util.Arrays;

public class ConsecutiveElementsInArray {
public static void main(String[] args) {
	int[] array = {5, 4, 1, 2};

    int min = Arrays.stream(array).min().getAsInt();
    int max = Arrays.stream(array).max().getAsInt();

    if (max - min == array.length - 1) {
        System.out.println("The elements are consecutive");
    } else {
        System.out.println("The elements are not consecutive");
    }
}
}