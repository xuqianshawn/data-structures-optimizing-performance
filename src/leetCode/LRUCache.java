package leetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LRUCache {
	// https://leetcode.com/problems/lru-cache/
	int _capacity;
	Map<Integer, Integer> map = new HashMap<>();
	Queue<Integer> queue = new LinkedList<Integer>();

	public LRUCache(int capacity) {
		_capacity = capacity;

	}

	public void refreshQueue(int key, boolean isGet) {
		if (map.containsKey(key)) {
			queue.remove(key);
		} else if (queue.size() >= _capacity) {
			if (isGet) {
				queue.poll();
			} else {
				// for put operation, need to remove the key from map
				int removeKey = queue.poll();
				map.remove(removeKey);
			}
		}
		queue.offer(key);
	}

	public int get(int key) {
		// check the queue
		if (!queue.contains(key)) {
			map.remove(key);
			return -1;
		}
		int target = map.get(key);
		refreshQueue(key, true);
		return target;
	}

	public void put(int key, int value) {
		refreshQueue(key, false);
		map.put(key, value);
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2 /* capacity */ );

		cache.put(2, 1);
		cache.put(1, 1);
		cache.put(2, 3); // evicts key 2
		cache.put(4, 4); // evicts key 1
		System.out.println(cache.get(1) + " expect: " + "-1"); // returns -1
																// (not found)
		System.out.println(cache.get(2) + " expect: " + "3"); // returns 3
		System.out.println(cache.get(4) + " expect: " + "4"); // returns 4

		LRUCache cache2 = new LRUCache(2 /* capacity */ );

		cache2.put(1, 1);
		cache2.put(2, 2);
		System.out.println(cache2.get(1) + " expect: " + "1"); // returns 1
		cache2.put(3, 3); // evicts key 2
		System.out.println(cache2.get(2) + " expect: " + "-1"); // returns -1
																// (not found)
		cache2.put(4, 4); // evicts key 1
		System.out.println(cache2.get(1) + " expect: " + "-1"); // returns -1
																// (not found)
		System.out.println(cache2.get(3) + " expect: " + "3"); // returns 3
		System.out.println(cache2.get(4) + " expect: " + "4"); // returns 4

		cache2 = new LRUCache(2 /* capacity */ );
		System.out.println(cache2.get(1) + " expect: " + "-1");
		cache2.put(2, 6);
		System.out.println(cache2.get(1) + " expect: " + "-1"); // returns 1
		cache2.put(1, 5);
		cache2.put(1, 2);
		System.out.println(cache2.get(1) + " expect: " + "2");
		System.out.println(cache2.get(2) + " expect: " + "6"); // returns 6
	}

}
