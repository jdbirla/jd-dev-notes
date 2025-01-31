package com.jd.interviewprep;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.jd.interviewprep.dsa.prob.string.AddStrings;

public class AddStringsTest {
	@Test
	void testAddStrings() {
		// Example 1: Without commas
		String num1 = "11";
		String num2 = "123";
		assertEquals("1,34", AddStrings.addStrings(num1, num2));

		// Example 2: Without commas
		num1 = "456";
		num2 = "77";
		assertEquals("5,33", AddStrings.addStrings(num1, num2));

		// Example 3: Without commas
		num1 = "0";
		num2 = "0";
		assertEquals("0", AddStrings.addStrings(num1, num2));

		// Example 4: With commas
		num1 = "11,000";
		num2 = "123,456";
		assertEquals("13,44,56", AddStrings.addStrings(num1, num2));

		// Additional test case: Large numbers without commas
		num1 = "999999999999999999";
		num2 = "1";
		assertEquals("1,00,00,00,00,00,00,00,00,00", AddStrings.addStrings(num1, num2));

		// Additional test case: Large numbers with commas
		num1 = "999,999,999,999,999,999";
		num2 = "1";
		assertEquals("1,00,00,00,00,00,00,00,00,00", AddStrings.addStrings(num1, num2));
	}
}
