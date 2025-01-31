package com.jd.nagaro;

import java.util.Arrays;
import java.util.OptionalInt;

public class TestMain {
public static void main(String[] args) {
	 int arr[] = new int[]{12,56,76,89,100,343,21,234};
           int min = Arrays.stream(arr).min().getAsInt();
           int max = Arrays.stream(arr).max().getAsInt();
           System.out.println(min + " "+ max);
}
}
