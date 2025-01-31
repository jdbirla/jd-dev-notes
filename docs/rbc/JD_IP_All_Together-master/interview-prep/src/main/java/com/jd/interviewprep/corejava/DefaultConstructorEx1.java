package com.jd.interviewprep.corejava;

public class DefaultConstructorEx1 {

	String name;

	public DefaultConstructorEx1(String name) {
		System.out.println("one arg contructor");

		this.name = name;
	}

	public DefaultConstructorEx1() {
		System.out.println("Default contructor");
	}
	
	public static void main(String[] args) {
		DefaultConstructorEx1 obj1 =  new DefaultConstructorEx1();
		System.out.println(obj1);
		DefaultConstructorEx1 obj2 =  new DefaultConstructorEx1("asda");
		System.out.println(obj2);
	}
	
	
}
