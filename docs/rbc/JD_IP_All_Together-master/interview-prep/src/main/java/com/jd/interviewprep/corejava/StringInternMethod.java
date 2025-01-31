package com.jd.interviewprep.corejava;

public class StringInternMethod {
	public static void main(String[] args) {
		// 1. Basic Usage:

		String s1 = new String("hello");
		String s2 = s1.intern();

		// In this example, s1 is created as a new string, and s2 is obtained by calling
		// intern on s1.
		// The == comparison returns false because s1 is a new string object, while s2
		// is a canonical representation from the string pool.
		System.out.println(s1 == s2); // false
		System.out.println(s1.equals(s2)); // true
		System.out.println(
				"--------------------------------------------------------------------------------------------------");
		
		//2. Comparing Interned Strings:

		String js1 = "hello";
		String js2 = new String("hello").intern();

		//In this case, s1 and s2 both reference the same canonical string from the string pool. The == comparison returns true.
		System.out.println(js1 == js2); // true
		System.out.println(js1.equals(js2)); // true

		
		System.out.println(
				"--------------------------------------------------------------------------------------------------");
		
		//3. String Concatenation:
		String ks1 = "hello";
		String ks2 = "world";
		String ks3 = (ks1 + ks2).intern();

		//The intern method is often used after string concatenation to ensure that the resulting string is from the string pool.
		//In this example, s3 is obtained by concatenating s1 and s2, and then calling intern.
		
		System.out.println(ks3 == "helloworld"); // true
		System.out.println(ks3 == (ks1 + ks2)); // false
		System.out.println(
				"--------------------------------------------------------------------------------------------------");
		//4. Performance Optimization:
		String as1 = "hello";
		String as2 = "hello";
		String as3 = new String("hello");
		//In this case, s1 and s2 reference the same string literal, while s3 is a new string object. 
		//However, by calling intern on s3, we get a reference to the canonical representation from the string pool, making the == comparison true.
		System.out.println(as1 == as2); // true
		System.out.println(as1 == as3); // false
		System.out.println(as1 == as3.intern()); // true

		
		
		
	}
	

}
