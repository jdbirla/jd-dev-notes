package com.jd.interviewprep.multithreading;

public class ThreadLocalExample {

	// Declare a ThreadLocal variable
	private static ThreadLocal<String> threadLocalVariable = new ThreadLocal<>();

	public static void main(String[] args) {
		// Create and start multiple threads
		Thread thread1 = new Thread(() -> {
			threadLocalVariable.set("Value set by Thread 1");
			printThreadLocalValue();
		});

		Thread thread2 = new Thread(() -> {
			threadLocalVariable.set("Value set by Thread 2");
			printThreadLocalValue();
		});

		thread1.start();
		thread2.start();
	}

	private static void printThreadLocalValue() {
		// Access the ThreadLocal variable within each thread
		System.out.println(Thread.currentThread().getName() + " - ThreadLocal Value: " + threadLocalVariable.get());
	}
}
