package com.jd.nagaro;

import java.util.Arrays;
import java.util.List;

public class MoveZerosToEnd {

	public static void main(String[] args) {
		int[] arr = {1,8,0,9,0,4,5,0};
		for (int i = 0; i < arr.length ; i++) {
			   System.out.println(arr[i]);
			}
			 
		moveZerosToEnd(arr);
		
		for (int i = 0; i < arr.length ; i++) {
		   System.out.println(arr[i]);
		}
		 
		
	}
	
	
	public static void moveZerosToEnd(int[] arr) {
	    int n = arr.length;
	    int count = 0; // Keeps track of non-zero elements

	    // Traverse the array. If the element is non-zero, swap it with the first zero encountered
	    for (int i = 0; i < n; i++) {
	        if (arr[i] != 0) {
	            int temp = arr[count];
	            arr[count] = arr[i];
	            arr[i] = temp;
	            count++;
	        }
	    }
	}
}
