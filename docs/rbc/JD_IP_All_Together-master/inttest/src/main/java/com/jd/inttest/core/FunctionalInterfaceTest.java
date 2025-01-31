package com.jd.inttest.core;

public class FunctionalInterfaceTest {
    public static void main(String[] args) {
        MultiplyInterface multiplyInterface = (int a, int b) -> a * b;
        System.out.println(multiplyInterface.multiply(5,4));
        MultiplyInterface plusInterface = (int a, int b) -> a + b;
        System.out.println(plusInterface.multiply(5,4));
    }
}
