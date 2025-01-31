package com.jd.interviewprep.multithreading;

public class DeadlockFixedExample {
    static Object lock1 = new Object();
    static Object lock2 = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                synchronized (lock1) {
                    System.out.println("Thread 1 acquired lock 1");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock2) {
                        System.out.println("Thread 1 acquired lock 2");
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                synchronized (lock1) { // Fixed order of locks acquired
                    System.out.println("Thread 2 acquired lock 1");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock2) {
                        System.out.println("Thread 2 acquired lock 2");
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
 
    }
}


