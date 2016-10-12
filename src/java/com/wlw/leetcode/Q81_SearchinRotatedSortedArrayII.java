package com.wlw.leetcode;

import java.util.Date;

public class Q81_SearchinRotatedSortedArrayII {

	public static void main(String[] args) {
		Q81_SearchinRotatedSortedArrayII test = new Q81_SearchinRotatedSortedArrayII();
		
		Date start = new Date();
		
		int[] nums = new int[]{6,7,9,1,4,5};
		Object result = test.search(nums,9);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public boolean search(int[] nums, int target) {
		for(int i=0;i<nums.length;i++)	{
			if(nums[i] == target)	{
				return true;
			}
		}
        return false;
    }
    
}

