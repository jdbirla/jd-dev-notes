package com.jd.interviewprep.dsa.howtouse;

import java.util.Stack;
import java.util.Collections;

public class StackDemo {
    public static void main(String[] args) {
        // Create a Stack
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        // Insert an element (Push)
        int newValue = 60;
        stack.push(newValue);

        // Remove an element (Pop)
        int removedValue = stack.pop();

        // Sort the Stack
        Collections.sort(stack);

        // Search for an element
        int searchValue = 30;
        int foundIndex = stack.search(searchValue);
        if (foundIndex != -1) {
            System.out.println("Element found at index: " + (stack.size() - foundIndex));
        } else {
            System.out.println("Element not found in the Stack.");
        }

        // Update an element (Replace)
        int updateIndex = 1;
        int updatedValue = 25;
        stack.set(updateIndex, updatedValue);

        // Print the Stack
        System.out.println("Stack after all operations: " + stack);
    }
}
