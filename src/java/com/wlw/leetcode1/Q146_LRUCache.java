package com.wlw.leetcode1;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q146_LRUCache {
	private static long totalCount = 0;
	public static void main(String[] args) {
		
		Date start = new Date();
		
		LRUCache cache = new LRUCache(2);

		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));       // returns 1
		cache.put(3, 3);    // evicts key 2
		System.out.println(cache.get(2));       // returns -1 (not found)
		cache.put(4, 4);    // evicts key 1
		System.out.println(cache.get(1));       // returns -1 (not found)
		System.out.println(cache.get(3));       // returns 3
		System.out.println(cache.get(4));       // returns 4
		cache.put(5, 5); 
		System.out.println(cache.get(3));
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime())+",totalCount:"+totalCount);
	}
	public static class LRUCache	{
		private int capacity;
		private Map<Integer,Integer> map;
		private List<Integer> list;
		public LRUCache(int capacity) {
	        this.capacity = capacity;
	        this.map = new HashMap<Integer,Integer>();
	        this.list = new LinkedList<Integer>();
	    }
	    
	    public int get(int key) {
	        if(!map.containsKey(key))	{
	        	return -1;
	        }
	        list.remove(new Integer(key));
	        list.add(key);
	        return map.get(key);
	    }
	    public void put(int key, int value) {
	        if(map.containsKey(key))	{
	        	map.put(key, value);
	        	list.remove(new Integer(key));
	        	list.add(key);
	        } else {
	        	if(map.size() == capacity)	{
	        		Integer old = list.remove(0);
	        		map.remove(old);
	        	}
	        	map.put(key, value);
	    		list.add(key);
	        }
	    }
	}
	
	
}

