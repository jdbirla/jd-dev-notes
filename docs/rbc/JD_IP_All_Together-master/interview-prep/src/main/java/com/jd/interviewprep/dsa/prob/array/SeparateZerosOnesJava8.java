package com.jd.interviewprep.dsa.prob.array;

import java.util.Arrays;

public class SeparateZerosOnesJava8 {
    public static void separateZerosOnes(int[] array) {
        if (array == null || array.length == 0) {
            System.out.println("Array is empty or null.");
            return;
        }

        int[] separatedArray = Arrays.stream(array)
                .boxed()
                .sorted((a, b) -> a.compareTo(b))
                .mapToInt(Integer::intValue)
                .toArray();
        printArray(separatedArray);
        System.arraycopy(separatedArray, 0, array, 0, array.length);
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static int[] separate0s1sSolution1(int arr[])
	 {
	  int count=0;
	  for (int i = 0; i < arr.length; i++) {
	   if(arr[i]==0)
	   {
	    count++;
	   }
	  }
	  for (int i = 0; i < count; i++) {
	   arr[i]=0;
	  }
	  for (int i = count; i < arr.length; i++) {
	   arr[i]=1;
	  }
	  return arr;
	 }
    
    public static void main(String[] args) {
        int[] array = {0, 1, 0, 1, 1, 0, 1, 0, 0, 1};

        System.out.println("Original array:");
        printArray(array);

        separateZerosOnes(array);

        System.out.println("Array after separating 0s and 1s:");
        printArray(array);
        
        
        separate0s1sSolution1(array);

        System.out.println("separate0s1sSolution1 Array after separating 0s and 1s:");
        printArray(array);
        
    }
}
