package com.jd.interviewprep.designpattern.builder;

public class Test {
//	The Builder pattern is a creational design pattern in Java that allows you to construct complex objects
//  step by step. It provides a way to create an object with many optional parameters, 
//	ensuring that the object is properly initialized and avoiding a long list of constructor arguments.
	
	public static void main(String[] args) {
		//HttpClient httpClient = new HttpClient("GET", "asd", null, null, null, null);
		  HttpClient build = new HttpClient.HttpClientBuilder().method("GET").url("http//asdadad").username("aaa").password("asd")
		  .body("asd").build();
		  System.out.println(build);
	}
}
