package com.jd.interviewprep.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuterService {
	public static void main(String[] args) {
		String threadName = Thread.currentThread().getName();
		System.out.println("Thread: " + threadName);
		ExecutorService executorService = Executors.newFixedThreadPool(3);

		// Create multiple Runnable tasks
		RunnableTask task1 = new RunnableTask("Task 1");
		RunnableTask task2 = new RunnableTask("Task 2");
		RunnableTask task3 = new RunnableTask("Task 3");

		// Submit tasks to the ExecutorService for execution
		executorService.submit(task1);
		executorService.submit(task2);
		executorService.submit(task3);

		// Shutdown the ExecutorService
		executorService.shutdown();
	}

//Runnable implementation representing a task
	static class RunnableTask implements Runnable {
		private final String taskName;

		RunnableTask(String taskName) {
			this.taskName = taskName;
		}

		@Override
		public void run() {
			// Print the thread and task information
			String threadName = Thread.currentThread().getName();
			System.out.println("Thread: " + threadName + " executing task: " + taskName);

			// Simulate some work
			for (int i = 0; i < 3; i++) {
				System.out.println("Task: " + taskName + " - Step " + (i + 1));
				try {
					Thread.sleep(1000); // Simulate work
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}

			System.out.println("Thread: " + threadName + " completed task: " + taskName);
		}
	}

}
