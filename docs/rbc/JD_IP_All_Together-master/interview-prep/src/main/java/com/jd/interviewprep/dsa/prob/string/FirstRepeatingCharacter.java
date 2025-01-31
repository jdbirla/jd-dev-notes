package com.jd.interviewprep.dsa.prob.string;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FirstRepeatingCharacter {
	 public static void main(String[] args) {
	        String str = "abcbdef";
	        System.out.println("First Repeating Character (Traditional): " + getRepeatingCharacter(str));
	        System.out.println("First Repeating Character (Java 8): " + getRepeatingCharacterJava8(str));
	    }
	 
	 public static Character getRepeatingCharacter(String str) {
	        Map<Character, Integer> countCharacters = new LinkedHashMap<>();
	        for (int i = 0; i < str.length(); i++) {
	            Character c = str.charAt(i);
	            if (!countCharacters.containsKey(c)) {
	                countCharacters.put(c, 1);
	            } else {
	                return c; // Return the first repeating character
	            }
	        }
	        return null; // No repeating character found
	    }

	    public static Character getRepeatingCharacterJava8(String str) {
	        List<Character> charList = str.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

	        return charList.stream()
	                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
	                .entrySet().stream()
	                .filter(entry -> entry.getValue() > 1) // Check for count greater than 1 (repeating)
	                .map(Map.Entry::getKey)
	                .findFirst()
	                .orElse(null); // No repeating character found
	    }

	   
}
