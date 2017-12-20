package com.wlw.leetcode1;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Q128_LongestConsecutiveSequence {

	public static void main(String[] args) {
		Q128_LongestConsecutiveSequence test = new Q128_LongestConsecutiveSequence();
		
		Date start = new Date();
		
		int[] nums = new int[]{1,2,8,10,9};
		Object result = test.longestConsecutive(nums);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int num : nums)	{
        	if(map.containsKey(num))	{
        		continue;
        	}
        	map.put(num,num);
        	if(map.containsKey(num-1))	{
        		int min = map.get(num-1);
        		map.put(num,min);
        		map.put(min,num);
        	}
        	if(map.containsKey(num+1))	{
        		int max = map.get(num+1);
        		if(map.containsKey(num))	{
        			int min = map.get(num);
            		map.put(max,min);
            		map.put(min,max);
        		} else {
        			map.put(num,max);
        			map.put(max,num);
        		}
        		
        	}
        }
        int max = 0;
        for(Integer key : map.keySet())	{
        	int len = map.get(key) - key + 1;
        	if(len > max)	{
        		max = len;
        	}
        }
        return max;
    }
}

