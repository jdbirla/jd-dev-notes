package com.jd.interviewprep.multithreading;

public class StaticSynchronizationExample {
	 private static int counter = 0;

	    // Static method with synchronization
	    public static synchronized void incrementCounter() {
	        for (int i = 0; i < 5; i++) {
	            // Simulating some work
	            System.out.println(Thread.currentThread().getName() + " - Incrementing counter: " + (++counter));
	            try {
	                Thread.sleep(100); // Simulate work
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	            }
	        }
	    }
	    public  synchronized void  incrementCounter1() {
	        for (int i = 0; i < 5; i++) {
	            // Simulating some work
	            System.out.println(Thread.currentThread().getName() + " - Incrementing counter: " + (++counter));
	            try {
	                Thread.sleep(100); // Simulate work
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	            }
	        }
	    }

	    public static void main(String[] args) {
	        // Create multiple threads that share the same class-level synchronization
	    	StaticSynchronizationExample s1 = new StaticSynchronizationExample();
	        Thread thread1 = new Thread(StaticSynchronizationExample::incrementCounter, "Thread 1");
	        Thread thread2 = new Thread(s1::incrementCounter1, "Thread 2");

	        // Start the threads
	        thread1.start();
	        thread2.start();
	    }
}
