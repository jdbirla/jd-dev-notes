package com.jd.interviewprep.dsa.howtouse;

import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        // Create a TreeMap
        TreeMap<String, Integer> map = new TreeMap<>();

        // Insert key-value pairs
        map.put("Apple", 10);
        map.put("Banana", 5);
        map.put("Orange", 15);
        map.put("Grapes", 8);

        // Remove a key-value pair
        String removedKey = "Banana";
        map.remove(removedKey);

        // Sort the TreeMap (no need, already sorted)

        // Search for a key
        String searchKey = "Orange";
        boolean isPresent = map.containsKey(searchKey);
        if (isPresent) {
            System.out.println("Key found in the TreeMap.");
        } else {
            System.out.println("Key not found in the TreeMap.");
        }

        // Update a value
        String updatedKey = "Apple";
        int oldValue = map.get(updatedKey);
        int updatedValue = 12;
        map.put(updatedKey, updatedValue);

        // Print the TreeMap
        System.out.println("TreeMap after all operations: " + map);
    }
}
