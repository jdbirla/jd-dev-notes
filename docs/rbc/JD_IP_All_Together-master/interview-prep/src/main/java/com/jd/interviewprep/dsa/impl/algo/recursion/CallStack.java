package com.jd.interviewprep.dsa.impl.algo.recursion;

public class CallStack {
    public static void methodThree() {
        System.out.println("Three");
    }

    public static void methodTwo() {
        methodThree();
        System.out.println("Two");
    }

    public static void methodOne() {
        methodTwo();
        System.out.println("One");
    }

    public static void main(String[] args) {

        methodOne();
    }
}
