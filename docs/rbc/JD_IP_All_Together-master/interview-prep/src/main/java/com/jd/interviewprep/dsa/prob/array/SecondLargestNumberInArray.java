package com.jd.interviewprep.dsa.prob.array;

import java.util.Arrays;
import java.util.Comparator;

public class SecondLargestNumberInArray {
	
	public static void main(String[] args) {
        int[] arr1={7,5,6,1,4,2};
        
       System.out.println("Using Stream on Arrays : "+usingStream(arr1));
       System.out.println("Using Iterator on Arrays : "+findSecondLargestNumberInTheArray(arr1));

	}
	
	public static int usingStream(int arr[])
	{
		
		Integer integer = Arrays.stream(arr)
		.boxed()
		.sorted(Comparator.comparing(Integer::intValue).reversed())
		.limit(2)
		.skip(1)
		.findFirst()
		.get();
		
		return integer;
		
	}
	
	public static int findSecondLargestNumberInTheArray(int array[])
    {
        // Initialize these to the smallest value possible
        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;
 
        // Loop over the array
        for (int i = 0; i < array.length; i++) { 
            // If current element is greater than highest 
            if (array[i] > highest) {
 
                // assign second highest element to highest element 
                secondHighest = highest;
 
                // highest element to current element
                highest = array[i];
            } else if (array[i] > secondHighest && array[i]!=highest)
                // Just replace the second highest
                secondHighest = array[i];
        }
 
        // After exiting the loop, secondHighest now represents the second
        // largest value in the array
        return secondHighest;
    }

}