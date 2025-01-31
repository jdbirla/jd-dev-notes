package com.jd.interviewprep.dsa.howtouse;

import java.util.Arrays;

public class ArrayDemo {
    public static void main(String[] args) {
        // Create an array
        int[] numbers = {10, 20, 30, 40, 50};

        // Insert an element
        int insertIndex = 2;
        int newValue = 60;
        System.out.println("Arrray before insert an element");
        System.out.println(display(numbers));
        
        numbers = insertElement(numbers, insertIndex, newValue);
        System.out.println("Arrray After insert an element");
        System.out.println(display(numbers));
        // Remove an element
        int removeIndex = 4;
        numbers = removeElement(numbers, removeIndex);
        System.out.println("Arrray After remove an element");
        System.out.println(display(numbers));
        // Sort the array
        Arrays.sort(numbers);
        System.out.println("Arrray After sort");
        System.out.println(display(numbers));
        // Search for an element
        int searchValue = 30;
        int foundIndex = searchElement(numbers, searchValue);
        if (foundIndex != -1) {
            System.out.println("Element found at index: " + foundIndex);
        } else {
            System.out.println("Element not found in the array.");
        }

        // Update an element
        int updateIndex = 1;
        int updatedValue = 25;
        numbers = updateElement(numbers, updateIndex, updatedValue);

        // Print the array
        System.out.println("Array after all operations: " + Arrays.toString(numbers));
    }

    // Insert an element at a specific index in the array
    public static int[] insertElement(int[] array, int index, int value) {
        int[] newArray = new int[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, index);
        newArray[index] = value;
        System.arraycopy(array, index, newArray, index + 1, array.length - index);
        return newArray;
    }

    // Remove an element at a specific index from the array
    public static int[] removeElement(int[] array, int index) {
        int[] newArray = new int[array.length - 1];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, array.length - index - 1);
        return newArray;
    }

    // Search for an element in the array
    public static int searchElement(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    // Update an element at a specific index in the array
    public static int[] updateElement(int[] array, int index, int value) {
        array[index] = value;
        return array;
    }
    
    public static StringBuilder display(int[] arr) {
    	StringBuilder newArray = new StringBuilder("[ ");
    	for (int i = 0; i < arr.length; i++) {
    		if(i==arr.length-1)
        		newArray.append(arr[i]);
    		else
        		newArray.append(arr[i]+" ,");
		}
    
		return newArray.append(" ];");
    	
    }
}
