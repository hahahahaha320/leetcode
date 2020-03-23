package com.wlw.leetcode;

import java.util.Date;

public class Q33_SearchinRotatedSortedArray {

	public static void main(String[] args) {
		Q33_SearchinRotatedSortedArray test = new Q33_SearchinRotatedSortedArray();
		
		Date start = new Date();
		
		int[] nums = new int[]{6,7,9,1,4,5};
		int result = test.search(nums,9);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public int search(int[] nums, int target) {
		for(int i=0;i<nums.length;i++)	{
			if(nums[i] == target)	{
				return i;
			}
		}
        return -1;
    }
    
}

