package com.jd.interviewprep.dsa.impl.ds.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadSafeCache<K, V> {
	private final Map<K, V> cache;
	private final int capacity;
	private final ScheduledExecutorService evictionScheduler;

	public ThreadSafeCache(int capacity, long evictionIntervalInMillis) {
		this.capacity = capacity;
		this.cache = new ConcurrentHashMap<>(capacity, 0.75f, 4);
		this.evictionScheduler = Executors.newScheduledThreadPool(1);

		// Schedule periodic eviction task
		evictionScheduler.scheduleAtFixedRate(this::evictLRUEntries, evictionIntervalInMillis, evictionIntervalInMillis,
				TimeUnit.MILLISECONDS);
	}

	public V get(K key) {
		return cache.get(key);
	}

	public void put(K key, V value) {
		if (cache.size() >= capacity) {
			evictLRUEntries();
		}
		cache.put(key, value);
	}

	private void evictLRUEntries() {
		if (cache.size() >= capacity) {
			// remove the least recently used element
			Map.Entry<K, V> eldestEntry = cache.entrySet().iterator().next();
			cache.remove(eldestEntry.getKey());
		}
	}

	public void remove(K key) {
		cache.remove(key);
	}

	public boolean containsKey(K key) {
		return cache.containsKey(key);
	}

	public int size() {
		return cache.size();
	}

	public void clear() {
		cache.clear();
	}

	public void shutdown() {
		evictionScheduler.shutdown();
	}

	public static void main(String[] args) {
		ThreadSafeCache<String, Integer> cache = new ThreadSafeCache<>(3, 5000); // Capacity: 3, Eviction Interval: 5
																					// seconds

		cache.put("one", 1);
		cache.put("two", 2);
		cache.put("three", 3);

		System.out.println("Cache Size: " + cache.size());
		System.out.println("Value for key 'two': " + cache.get("two"));

		// Wait for some time to trigger eviction
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Cache Size after eviction: " + cache.size());
		System.out.println("Contains key 'two'? " + cache.containsKey("two"));

		cache.shutdown();
	}
}
