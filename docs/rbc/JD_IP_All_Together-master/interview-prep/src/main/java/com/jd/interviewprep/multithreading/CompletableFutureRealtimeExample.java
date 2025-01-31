package com.jd.interviewprep.multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureRealtimeExample {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		// Example: Fetching user name asynchronously
		CompletableFuture<String> nameFuture = CompletableFuture.supplyAsync(() -> {
			// Simulate fetching user name from an external service
			System.out.println("Fetching user name asynchronously...");
			sleep(2000);
			// Uncomment the next line to simulate an exception during the computation
			// throw new RuntimeException("Error fetching user name");
			return "John Doe";
		});

		// Example: Transforming the user name
		CompletableFuture<String> transformedNameFuture = nameFuture.thenApply(name -> {
			System.out.println("Transforming user name...");
			return "Mr. " + name.toUpperCase();
		});

		// Example: Printing the result
		CompletableFuture<Void> printResultFuture = transformedNameFuture.thenAccept(transformedName -> {
			System.out.println("Final result: " + transformedName);
		});

		// Example: Handling exceptions
		CompletableFuture<?> exceptionFuture = CompletableFuture.supplyAsync(() -> {
			throw new RuntimeException("Simulating an exception");
		}).exceptionally(throwable -> {
			System.err.println("Exception occurred: " + throwable.getMessage());
			return "Default Result";
		});

		// Wait for all futures to complete
		printResultFuture.get();
		String exceptionResult = (String) exceptionFuture.get();

		System.out.println("Exception Handling Result: " + exceptionResult);
	}

	private static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			throw new RuntimeException(e);
		}
	}
}
