package com.jd.interviewprep.dsa.howtouse;

import java.util.LinkedHashSet;
import java.util.ArrayList;
import java.util.Collections;

public class LinkedHashSetDemo {
    public static void main(String[] args) {
        // Create a LinkedHashSet
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
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

        // Sort the LinkedHashSet
        ArrayList<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);

        // Search for an element
        int searchValue = 20;
        boolean isPresent = set.contains(searchValue);
        if (isPresent) {
            System.out.println("Element found in the LinkedHashSet.");
        } else {
            System.out.println("Element not found in the LinkedHashSet.");
        }

        // Update an element
        int oldValue = 20;
        int updatedValue = 25;
        set.remove(oldValue);
        set.add(updatedValue);

        // Print the LinkedHashSet
        System.out.println("LinkedHashSet after all operations: " + set);
    }
}
