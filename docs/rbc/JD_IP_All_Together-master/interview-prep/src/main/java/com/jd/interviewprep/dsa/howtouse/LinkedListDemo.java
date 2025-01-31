package com.jd.interviewprep.dsa.howtouse;

import java.util.LinkedList;
import java.util.Collections;

public class LinkedListDemo {
    public static void main(String[] args) {
        // Create a LinkedList
        LinkedList<Integer> numbers = new LinkedList<>();
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

        // Sort the LinkedList
        Collections.sort(numbers);

        // Search for an element
        int searchValue = 30;
        int foundIndex = numbers.indexOf(searchValue);
        if (foundIndex != -1) {
            System.out.println("Element found at index: " + foundIndex);
        } else {
            System.out.println("Element not found in the LinkedList.");
        }

        // Update an element
        int updateIndex = 1;
        int updatedValue = 25;
        numbers.set(updateIndex, updatedValue);

        // Print the LinkedList
        System.out.println("LinkedList after all operations: " + numbers);
    }
}

