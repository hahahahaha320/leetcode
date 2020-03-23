package com.wlw.leetcode3;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Q312_BurstBallons {

	public static void main(String[] args) {
		Q312_BurstBallons test = new Q312_BurstBallons();
		
		Date start = new Date();
		
		int[] nums = new int[]{3,1,5,8};
//		int[] nums = new int[]{8,2,6,8,9,8,1,4,1,5,4,2,2,2,3,5,6,5};
		
		Object result = test.maxCoins(nums);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	
	private Map<String,Integer> cache = new HashMap<String,Integer>();
	public int maxCoins(int[] nums) {
        if(nums.length == 1)	{
        	return nums[0];
        }
        if(nums.length == 2)	{
        	int max = Math.max(nums[0],nums[1]);
        	int min = Math.min(nums[0],nums[1]);
        	return max*min + max;
        }
        String key = "";
        for(int i=0;i<nums.length;i++)	{
        	key = key + "_" + nums[i];
        }
        if(cache.containsKey(key))	{
        	return cache.get(key);
        }
        int maxScore = 0;
        for(int i=0;i<nums.length;i++)	{
        	int left = i==0?1:nums[i-1];
        	int right = i==nums.length-1?1:nums[i+1];
        	int score = left*right*nums[i] + maxCoins(trimIndex(nums,i));
        	maxScore = score>maxScore?score:maxScore;
        }
        cache.put(key,maxScore);
		return maxScore;
    }
	private int[] trimIndex(int[] nums,int index)	{
		int[] trimed = new int[nums.length - 1];
		int oriIndex = 0;
		for(int i=0;i<nums.length - 1;i++)	{
			if(oriIndex == index)	{
				oriIndex++;
			}
			trimed[i] = nums[oriIndex];
			oriIndex++;
		}
		return trimed;
	}
}

