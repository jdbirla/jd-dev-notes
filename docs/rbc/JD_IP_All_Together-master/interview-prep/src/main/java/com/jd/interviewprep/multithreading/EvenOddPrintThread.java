package com.jd.interviewprep.multithreading;

public class EvenOddPrintThread {

	static int counter = 1;
	   static Object lock = new Object();
	   
	   static class EvenThread implements Runnable {
	      public void run() {
	         while (counter < 100) {
	            synchronized (lock) {
	               if (counter % 2 == 0) {
	                  System.out.println(Thread.currentThread().getName() + ": " + counter++);
	                  lock.notify();
	               } else {
	                  try {
	                     lock.wait();
	                  } catch (InterruptedException e) {
	                     e.printStackTrace();
	                  }
	               }
	            }
	         }
	      }
	   }
	   
	   static class OddThread implements Runnable {
	      public void run() {
	         while (counter < 100) {
	            synchronized (lock) {
	               if (counter % 2 != 0) {
	                  System.out.println(Thread.currentThread().getName() + ": " + counter++);
	                  lock.notify();
	               } else {
	                  try {
	                     lock.wait();
	                  } catch (InterruptedException e) {
	                     e.printStackTrace();
	                  }
	               }
	            }
	         }
	      }
	   }
	   
	   public static void main(String[] args) {
	      Thread evenThread = new Thread(new EvenThread(), "Even");
	      Thread oddThread = new Thread(new OddThread(), "Odd");
	      evenThread.start();
	      oddThread.start();
	   }

}
