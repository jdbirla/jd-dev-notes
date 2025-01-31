package com.jd.interviewprep.dsa.prob.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class FindFirstRepeatingElementInArray {
public static void main(String[] args) {
	Integer[] array = {1, 2, 3, 4, 2, 5};

    Set<Integer> set = new HashSet<>();
    Optional<Integer> firstRepeatingElement = Arrays.stream(array)
            .filter(x -> !set.add(x))
            .findFirst();

    if (firstRepeatingElement.isPresent()) {
        System.out.println(firstRepeatingElement.get());
    } else {
        System.out.println("No repeating element found");
    }
}
}
