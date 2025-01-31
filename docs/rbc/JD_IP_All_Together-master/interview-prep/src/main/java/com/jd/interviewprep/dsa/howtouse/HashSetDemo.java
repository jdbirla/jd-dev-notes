package com.jd.interviewprep.dsa.howtouse;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;

public class HashSetDemo {
    public static void main(String[] args) {
        // Create a HashSet
        HashSet<Integer> set = new HashSet<>();
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);
        set.add(50);

        // Insert an element
        int newValue = 60;
        set.add(newValue);

        // Remove an element
        int removedValue = 30;
        set.remove(removedValue);

        // Sort the HashSet
        ArrayList<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);

        // Search for an element
        int searchValue = 20;
        boolean isPresent = set.contains(searchValue);
        if (isPresent) {
            System.out.println("Element found in the HashSet.");
        } else {
            System.out.println("Element not found in the HashSet.");
        }

        // Update an element
        int oldValue = 20;
        int updatedValue = 25;
        set.remove(oldValue);
        set.add(updatedValue);

        // Print the HashSet
        System.out.println("HashSet after all operations: " + set);
    }
}
