package com.jd.interviewprep.corejava;

interface Interface1 {
	default void someMethod() {
		System.out.println("Interface1's default method");
	}
}

interface Interface2 {
	default void someMethod() {
		System.out.println("Interface2's default method");
	}
}

public class DainmondProblemFunctionalInterface implements Interface1, Interface2 {
	@Override
	public void someMethod() {
		// Explicitly choose which method to use
		Interface1.super.someMethod();
	}
}
