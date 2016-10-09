package com.wlw.leetcode;

import java.util.Date;

public class Q75_SortColors2 {

	public static void main(String[] args) {
		Q75_SortColors2 test = new Q75_SortColors2();
		
		Date start = new Date();
		
		int[] nums = new int[]{0,1,2,0,2};
		test.sortColors(nums);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		Util.printArray(nums);
	}
	public void sortColors(int[] nums) {
	    int i=-1, j=-1;
	    for(int p = 0; p < nums.length; p++) {
	       int v = nums[p];
	       nums[p] = 2;
	       if (v == 0) {
	          nums[++j] = 1;
	          nums[++i] = 0;
	       } else if (v == 1) {
	           nums[++j] = 1;
	       }
	    }
	}
}

