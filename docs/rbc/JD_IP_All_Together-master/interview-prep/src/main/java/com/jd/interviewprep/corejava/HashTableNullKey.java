package com.jd.interviewprep.corejava;

import java.util.HashMap;
import java.util.Hashtable;

public class HashTableNullKey {
	 public static void main(String[] args) {
		 
		 HashMap<String, String> hashMap = new HashMap<>();

	        // Inserting a key-value pair with null key
	        hashMap.put(null, "Value for null key");

	        // Inserting a key-value pair with non-null key
	        hashMap.put("Key", "Value");

	        System.out.println("HashMap: " + hashMap);
	        
	        Hashtable<String, String> hashtable = new Hashtable<>();

	        // Attempting to insert a key-value pair with null key
	        // This will throw a NullPointerException
	       // hashtable.put(null, "Value for null key");
	        // Attempting to insert a key-value pair with non-null key
	       hashtable.put("Key", null);

	        System.out.println("Hashtable: " + hashtable);
	    }

}
