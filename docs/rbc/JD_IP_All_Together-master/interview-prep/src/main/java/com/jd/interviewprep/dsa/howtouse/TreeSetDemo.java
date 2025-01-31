package com.jd.interviewprep.dsa.howtouse;

import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        // Create a TreeSet
        TreeSet<Integer> set = new TreeSet<>();
        set.add(30);
        set.add(10);
        set.add(50);
        set.add(20);
        set.add(40);

        // Insert an element
        int newValue = 60;
        set.add(newValue);

        // Remove an element
        int removedValue = 30;
        set.remove(removedValue);

        // Sort the TreeSet (no need, already sorted)

        // Search for an element
        int searchValue = 20;
        boolean isPresent = set.contains(searchValue);
        if (isPresent) {
            System.out.println("Element found in the TreeSet.");
        } else {
            System.out.println("Element not found in the TreeSet.");
        }

        // Update an element
        int oldValue = 20;
        int updatedValue = 25;
        set.remove(oldValue);
        set.add(updatedValue);

        // Print the TreeSet
        System.out.println("TreeSet after all operations: " + set);
    }
}
