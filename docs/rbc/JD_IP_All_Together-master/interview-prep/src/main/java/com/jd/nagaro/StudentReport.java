package com.jd.nagaro;

public class StudentReport {
	
	public static void main(String[] args) {
		int [][] marks = {{75,76,65,87,87},{78,76,68,56,89},{67,87,78,77,65}};
		int[] calculateTotalMarks = calculateTotalMarks(3,5,marks);
		System.out.println(calculateTotalMarks);
		for (int i : calculateTotalMarks) {
			System.out.println(i);
		}
		
	}
	public static int[] calculateTotalMarks(int nVal, int mVal, int[][] marks) {
	    int n = nVal; // number of students
	    int m = mVal; // number of subjects
	    
	    int[] totalMarks = new int[n]; // array to store total marks of each student
	    
	    // calculate average marks of each subject
	    double[] avgMarks = new double[m];
	    for (int j = 0; j < m; j++) {
	        double sum = 0;
	        for (int i = 0; i < n; i++) {
	            sum += marks[i][j];
	        }
	        avgMarks[j] = sum / n;
	    }
	    
	    // find the subject with the lowest average marks
	    int minAvgIndex = 0;
	    for (int j = 1; j < m; j++) {
	        if (avgMarks[j] < avgMarks[minAvgIndex]) {
	            minAvgIndex = j;
	        }
	    }
	    
	    // calculate total marks of each student in all other subjects
	    for (int i = 0; i < n; i++) {
	        int sum = 0;
	        for (int j = 0; j < m; j++) {
	            if (j != minAvgIndex) {
	                sum += marks[i][j];
	            }
	        }
	        totalMarks[i] = sum;
	    }
	    
	    return totalMarks;
	}

}
