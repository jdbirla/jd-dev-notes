package com.jd.test.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by jd birla on 02-05-2023 at 21:40
 */
public class JavaCondingTest {

    public static void main(String[] args) {
        // Sequncial count characters
        //Input : "aabbbccddbbeeb'
        //output    : "2a3b2c2d2b2e1b"
        // extracted("aabbbccddbbeeb");

        // Write a Java program to print a Fibonacci sequence using recursion.
        //Input : 10
        //output    : "0, 1, 1, 2, 3, 5, 8, 13, 21, 34,
        //printFibonacciSequence(10);


        // How do you check whether a string is a palindrome in Java?
        // input abcddcba  , jitendra
        // Out put : Palindrom , not-palindrom
        //checkPalindromeString("abcddcba");

        // How can you find the factorial of an integer in Java?
        //  input : 5
        // Output : 120
       // long factorial = factorial(5);
       // System.out.println(factorial);


        //Java program to reverse a String
        // input : jitendra
        //output: jitendra
        //reverseString("jitendra");


        //if String has all unique characters Using HashSet:
        //input :apple
        // output:  unique characters
        //hasAllUniqueChars("apple");

        //Java Program to check if one String is rotation of another.
        // input : "java2blog", "blogjava2"
        // Output:rotation , not rotation
     //   isRotation("java2blog", "avablog2j");


        // Java Program to find duplicate Characters in a String
        // input : java2blog.com
        // output:duplicate character : a ======  count : 2
                  //duplicate character : o ======  count : 2
        //duplicateCharsinString("java2blog.com ");

        // Arrays different problems
        int[] arr =  {5, 2, 7, 1, 9, 3};
         arraysProblems(arr);
    }

    private static void extracted(String str) {
        StringBuilder sb = new StringBuilder();
        char currentChar = str.charAt(0);
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == currentChar) {
                count++;
            } else {
                sb.append(count).append(currentChar);
                currentChar = str.charAt(i);
                count = 1;
            }
        }
        sb.append(count).append(currentChar);
        String finalStr = sb.toString();
        System.out.println(finalStr);
    }

    public static void printFibonacciSequence(int count) {
        int a = 0;
        int b = 1;
        int c = 1;

        for (int i = 1; i <= count; i++) {
            System.out.print(a + ", ");

            a = b;
            b = c;
            c = a + b;
        }
    }

    public static void checkPalindromeString(String input) {
        boolean result = true;
        int length = input.length();

        for (int i = 0; i < length/2; i++) {
            if (input.charAt(i) != input.charAt(length - i - 1)) {
                result = false;
                break;
            }
        }

        System.out.println(result?"Palindrom":"Nor-Palindrom");
    }

    public static long factorial(long n) {
        if (n == 1)
            return 1;
        else
            return (n * factorial(n - 1));
    }

    public static void reverseString(String blogName)
    {
        //StringBuffer sb = new StringBuffer(blogName);
        //System.out.println("Reverse of java2blog is:" + sb.reverse());


        StringBuilder reverse = new StringBuilder();
        for (int i = blogName.length() - 1; i >= 0; i--) {
             reverse.append(blogName.charAt(i));
        }
        System.out.println("Reverse of java2blog is: " + reverse);
    }

    public static void hasAllUniqueChars(String word)
    {

        HashSet alphaSet=new HashSet();
   Boolean flag = true;
        for(int index=0;index < word.length(); index ++)   {

            char c =word.charAt(index);

            // If Hashset's add method return false,that means it is already present in HashSet
            if(!alphaSet.add(c))
                flag = false;
        }

         if(flag)
             System.out.println("unique chars");
         else
             System.out.println("not unique chars");

    }

    public static void isRotation(String str, String rotation) {
       Boolean flag = false;

        String str2 = str + str;

        if (str2.contains(rotation)) {
            flag = true;
        }
        if(flag)
            System.out.println("rotation ");
        else
            System.out.println("not rotation ");
    }

    public static void duplicateCharsinString(String str )
    {
        Map<Character, Long> charCountMap = new HashMap();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1L);
            }

        }
        for (Character c : charCountMap.keySet()) {
            if (charCountMap.get(c) > 1)
                System.out.println("duplicate character : " + c + " ====== " + " count : " + charCountMap.get(c));

        }
    }

    public static void arraysProblems(int[] arr)
    {
        // Finding the smallest element
        int min = Arrays.stream(arr).min().getAsInt();
        System.out.println("Smallest Element in the array: " + min);

        // Finding the largest element
        int max = Arrays.stream(arr).max().getAsInt();
        System.out.println("Largest Element in the array: " + max);
    }
}