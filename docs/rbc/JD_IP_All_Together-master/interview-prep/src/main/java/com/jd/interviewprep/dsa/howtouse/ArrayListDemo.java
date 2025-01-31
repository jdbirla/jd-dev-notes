package com.jd.interviewprep.dsa.howtouse;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListDemo {
    public static void main(String[] args) {
        // Create an ArrayList
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);

        // Insert an element
        int insertIndex = 2;
        int newValue = 60;
        numbers.add(insertIndex, newValue);

        // Remove an element
        int removeIndex = 4;
        numbers.remove(removeIndex);

        // Sort the ArrayList
        Collections.sort(numbers);

        // Search for an element
        int searchValue = 30;
        int foundIndex = numbers.indexOf(searchValue);
        if (foundIndex != -1) {
            System.out.println("Element found at index: " + foundIndex);
        } else {
            System.out.println("Element not found in the ArrayList.");
        }

        // Update an element
        int updateIndex = 1;
        int updatedValue = 25;
        numbers.set(updateIndex, updatedValue);

        // Print the ArrayList
        System.out.println("ArrayList after all operations: " + numbers);
    }
}
