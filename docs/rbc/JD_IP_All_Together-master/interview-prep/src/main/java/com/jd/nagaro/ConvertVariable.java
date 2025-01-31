package com.jd.nagaro;

public class ConvertVariable {
	
	public static void main(String[] args) {
		String cppName = "this_is_a_variable";
		String javaName = convertVariableName(cppName);
		System.out.println(javaName); // output: thisIsAVariable

		String javaName2 = "thisIsAVariable";
		String cppName2 = convertVariableName(javaName2);
		System.out.println(cppName2); // output: this is a variable

		String name3 = "exampleVariable123";
		String convertedName3 = convertVariableName(name3);
		System.out.println(convertedName3); // output: exampleVariable123
	}

	public static String convertVariableName(String name) { // check if the name is in C++ format (with underscores)
	    if (name.contains("_")) {
	        // split the name into words
	        String[] words = name.split("_");
	        // concatenate the words in CamelCase format
	        StringBuilder javaName = new StringBuilder();
	        for (String word : words) {
	            javaName.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1));
	        }
	        return javaName.toString();
	    }
	    // check if the name is in Java format (CamelCase)
	    else if (name.matches("[a-z]+[A-Z][a-z]+.*")) {
	        // split the name into words
	        StringBuilder cppName = new StringBuilder();
	        int i = 0;
	        while (i < name.length()) {
	            char c = name.charAt(i);
	            if (Character.isUpperCase(c)) {
	                cppName.append("_").append(Character.toLowerCase(c));
	            } else {
	                cppName.append(c);
	            }
	            i++;
	        }
	        return cppName.toString();
	    }
	    // name is already in the correct format
	    else {
	        return name;
	    }}
}
