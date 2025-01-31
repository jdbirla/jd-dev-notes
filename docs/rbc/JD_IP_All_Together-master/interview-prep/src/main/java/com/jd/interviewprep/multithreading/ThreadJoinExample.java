package com.jd.interviewprep.multithreading;

public class ThreadJoinExample {
	 public static void main(String[] args) {
	        Runnable runnable = () -> {
	            for (int i = 0; i < 5; i++) {
	                sleep(1000);
	                System.out.println("running");
	            }
	        };

	        Thread thread = new Thread(runnable);
	        thread.setDaemon(true);
	        thread.start();

	        try {
	            thread.join(2000);
	        } catch (InterruptedException e) {
	            throw new RuntimeException(e);
	        }

	    }

	    private static void sleep(int i) {
	        try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {
	            throw new RuntimeException(e);
	        }
	    }
}
