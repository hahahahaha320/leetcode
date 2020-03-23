package com.wlw.leetcode1;

import java.util.Date;

public class Q153_FindMinimuminRotatedSortedArray2 {
	private static long totalCount = 0;
	public static void main(String[] args) {
		Q153_FindMinimuminRotatedSortedArray2 test = new Q153_FindMinimuminRotatedSortedArray2();
		
		Date start = new Date();
		
		int[] nums = new int[]{4,5,6,7,1,2};
		Object result = test.findMin(nums);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime())+",totalCount:"+totalCount);
		System.out.println(result);
	}
	public int findMin(int[] nums) {
	       return find(nums,0,nums.length-1);
	    }
	    
	    public int find(int[] nums, int l, int r) {
	        if(nums[l] <= nums[r]) {
	            return nums[l];
	        }
	        int mid = (l + r) / 2;
	        return Math.min(find(nums,l,mid),find(nums,mid+1,r));
	    }
}

