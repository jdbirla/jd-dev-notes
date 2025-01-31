package com.jd.inttest.core;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(calCulateFact(5));
    }

    public static int calCulateFact(int n)
    {
        if(n <= 1)
        {
            return 1;
        }else
        {
            return n * calCulateFact(n-1);
        }

    }
}
