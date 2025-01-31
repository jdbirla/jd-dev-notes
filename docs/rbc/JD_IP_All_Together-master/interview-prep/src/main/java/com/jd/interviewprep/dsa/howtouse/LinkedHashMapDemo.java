package com.jd.interviewprep.dsa.howtouse;

import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.Collections;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        // Create a LinkedHashMap
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        // Insert key-value pairs
        map.put("Apple", 10);
        map.put("Banana", 5);
        map.put("Orange", 15);
        map.put("Grapes", 8);

        // Remove a key-value pair
        String removedKey = "Banana";
        map.remove(removedKey);

        // Sort the LinkedHashMap (no direct sorting)

        // Search for a key
        String searchKey = "Orange";
        boolean isPresent = map.containsKey(searchKey);
        if (isPresent) {
            System.out.println("Key found in the LinkedHashMap.");
        } else {
            System.out.println("Key not found in the LinkedHashMap.");
        }

        // Update a value
        String updatedKey = "Apple";
        int oldValue = map.get(updatedKey);
        int updatedValue = 12;
        map.put(updatedKey, updatedValue);

        // Print the LinkedHashMap
        System.out.println("LinkedHashMap after all operations: " + map);
    }
}
