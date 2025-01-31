package com.jd.interviewprep.corejava;

public class SubstringMethodPorblems {
	public static void main(String[] args) {
		// 1. Memory Overhead:
//		When you create a substring using the substring method, it references the original string and holds a reference to the character array of the original string. This means that if you keep the substring for an extended period, the memory occupied by the original string and the substring may not be released by the garbage collector, leading to potential memory overhead.

		String original = "Hello, World!";
		String substring = original.substring(7); // "World!"

		// The substring still references the original character array
		// If the original string is large and no longer needed, memory may not be
		// freed.

		// 2. Impact on Garbage Collection:
		// substrings from a large original string and keeping them in memory for a long
		// time can affect garbage collection. The original string and all its
		// substrings may be retained in memory as long as any one of them is reachable.

		// 3. Time Complexity:
		// Creating a substring involves copying a portion of the original string's
		// character array. The time complexity for creating a substring is O(n), where
		// n is the length of the substring. This may not be significant for small
		// substrings but can impact performance when dealing with large strings.

		String original1 = "Hello, World!";
		String substring1 = original.substring(7, 12); // "World"

		// Creating a substring involves copying characters, which takes time.

		// 4. Immutability:
		// Strings in Java are immutable, meaning their content cannot be changed after
		// creation. When you perform operations that involve substrings, a new string
		// is created. While immutability has benefits, such as thread safety, it can
		// also lead to increased memory usage and additional object creations.

		String original2 = "Hello, World!";
		String modified = original.substring(7, 12).toUpperCase(); // "WORLD"

		// A new string is created for the modified substring.

	}

}
