package com.wlw.leetcode;

import java.util.Date;

public class Q33_SearchinRotatedSortedArray {

	public static void main(String[] args) {
		Q33_SearchinRotatedSortedArray test = new Q33_SearchinRotatedSortedArray();
		
		Date start = new Date();
		
		int[] nums = new int[]{6,7,9,1,4,5};
		int[] result = test.searchRange(nums,9);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public int[] searchRange(int[] nums, int target) {
		
        return null;
    }
    
}

