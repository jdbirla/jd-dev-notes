package com.jd.interviewprep.dsa.howtouse;

import java.util.Hashtable;

public class HashTableDemo {
    public static void main(String[] args) {
        // Create a Hashtable
        Hashtable<String, Integer> table = new Hashtable<>();

        // Insert key-value pairs
        table.put("Apple", 10);
        table.put("Banana", 5);
        table.put("Orange", 15);
        table.put("Grapes", 8);

        // Remove a key-value pair
        String removedKey = "Banana";
        table.remove(removedKey);

        // Sort the Hashtable (no direct sorting)

        // Search for a key
        String searchKey = "Orange";
        boolean isPresent = table.containsKey(searchKey);
        if (isPresent) {
            System.out.println("Key found in the Hashtable.");
        } else {
            System.out.println("Key not found in the Hashtable.");
        }

        // Update a value
        String updatedKey = "Apple";
        int oldValue = table.get(updatedKey);
        int updatedValue = 12;
        table.put(updatedKey, updatedValue);

        // Print the Hashtable
        System.out.println("Hashtable after all operations: " + table);
    }
}
