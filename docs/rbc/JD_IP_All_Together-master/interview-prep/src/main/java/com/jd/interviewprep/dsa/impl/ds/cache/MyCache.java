package com.jd.interviewprep.dsa.impl.ds.cache;

import java.util.HashMap;
import java.util.Map;

public class MyCache<K, V> {

	private final Map<K, V> cache;
	private final int maxSize;

	public MyCache(int maxSize) {
		this.cache = new HashMap<>();
		this.maxSize = maxSize;
	}

	public V get(K key) {
		if (cache.containsKey(key)) {
			return cache.get(key);
		}
		return null;
	}

	public void put(K key, V value) {
		if (cache.size() == maxSize) {
			// remove the least recently used element
			K leastRecentlyUsedKey = cache.keySet().iterator().next();
			cache.remove(leastRecentlyUsedKey);
		}
		cache.put(key, value);
	}

	public int size() {
		return cache.size();
	}

	@Override
	public String toString() {
		return "MyCache{" + "cache=" + cache + ", maxSize=" + maxSize + '}';
	}

	public static void main(String[] args) {
		// Create a cache with a maximum size of 3
		MyCache<String, Integer> cache = new MyCache<>(3);
		// Add some key-value pairs
		cache.put("a", 1);
		cache.put("b", 2);
		cache.put("c", 3);
		// Get the value for key "a"
		Integer value = cache.get("a");
		System.out.println(value); // Output: 1
		// Add another key-value pair, which will evict the least recently used element
		cache.put("d", 4);
		// Get the value for key "a" again
		value = cache.get("a");
		System.out.println(value); // Output: null
		// Check the current size of the cache
		int size = cache.size();
		System.out.println(size); // Output: 3
		System.out.println(cache.toString());
	}

}
