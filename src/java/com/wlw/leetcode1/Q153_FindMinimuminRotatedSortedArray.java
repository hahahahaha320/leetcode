package com.wlw.leetcode1;

import java.util.Date;

public class Q153_FindMinimuminRotatedSortedArray {
	private static long totalCount = 0;
	public static void main(String[] args) {
		Q153_FindMinimuminRotatedSortedArray test = new Q153_FindMinimuminRotatedSortedArray();
		
		Date start = new Date();
		
		int[] nums = new int[]{3,1,3};
		Object result = test.findMin(nums);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime())+",totalCount:"+totalCount);
		System.out.println(result);
	}
	public int findMin(int[] nums) {
        int min = nums[0];
        for(int i=1;i<nums.length;i++)	{
        	if(nums[i] < min)	{
        		return nums[i];
        	}
        }
        return min;
    }
}

