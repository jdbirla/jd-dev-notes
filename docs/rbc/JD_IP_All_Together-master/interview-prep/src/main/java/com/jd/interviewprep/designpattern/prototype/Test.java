package com.jd.interviewprep.designpattern.prototype;

public class Test {

	public static void main(String[] args) {
		String removeCharacters = removeCharacters("weelcOome");
		System.out.println(removeCharacters);
	}

	public static String removeCharacters(String str) {
		if (str == null) {
			return str;
		}
		StringBuilder newStr = new StringBuilder();
		char prevChar = str.charAt(0);
		newStr.append(prevChar);
		for (int i = 0; i < str.length(); i++) {
			char CurrentcharAt = str.charAt(i);
			if (Character.toLowerCase(CurrentcharAt) != Character.toLowerCase(prevChar)) {
				newStr.append(CurrentcharAt);
				prevChar = CurrentcharAt;
			}
		}

		return newStr.toString();
	}

}
