package com.jd.interviewprep.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FailFastMap {

	public static void main(String[] args) {
//it will throw ConcurrentModificationException as we are adding values in iteration 
		// as iterator take snapshot of map and when are changing modcount doesn't match
		// and it throws exception
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "one");
		map.put(2, "two");

		// Getting an Iterator from map
		Iterator it = map.keySet().iterator();
		try {
			while (it.hasNext()) {
				Integer key = (Integer) it.next();
				System.out.println(key + " : " + map.get(key));
				map.put(3, "three");
			}
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();

		}
		System.out.println("-------------------------------------------------------------------------------");

	//In ConcurrentHahMap we can modify value in iterator but there may be race conditions and other concurrency issues.
//in concurrenthahmap we need to use putIfAbsent, compute, computeIfAbsent, computeIfPresent, etc
		ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();

		concurrentHashMap.put("One", 1);
		concurrentHashMap.put("Two", 2);
		concurrentHashMap.put("Three", 3);

		// Attempting to modify the ConcurrentHashMap while iterating
		Iterator<String> iterator = concurrentHashMap.keySet().iterator();

		while (iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key + ": " + concurrentHashMap.get(key));

			// Uncommenting the next line will result in a ConcurrentModificationException
			concurrentHashMap.put("Four", 4);
		}
	}

}
