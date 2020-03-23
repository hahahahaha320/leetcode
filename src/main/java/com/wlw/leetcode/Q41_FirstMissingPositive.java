package com.wlw.leetcode;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Q41_FirstMissingPositive {

	public static void main(String[] args) {
		Q41_FirstMissingPositive test = new Q41_FirstMissingPositive();
		
		Date start = new Date();
		
		int[] nums = new int[]{1};
		int result = test.firstMissingPositive(nums);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++)	{
        	set.add(nums[i]);
        }
        for(int i=1;i<=nums.length+1;i++)	{
        	if(!set.contains(i))	{
        		return i;
        	}
        }
        return 1;
    }
}

