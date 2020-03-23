package com.wlw.leetcode1;

import java.util.Date;

public class Q154_FindMinimuminRotatedSortedArrayII {
	private static long totalCount = 0;
	public static void main(String[] args) {
		Q154_FindMinimuminRotatedSortedArrayII test = new Q154_FindMinimuminRotatedSortedArrayII();
		
		Date start = new Date();
		
		int[] nums = new int[]{4,6,6,7,0,1,2,3,4};
		Object result = test.findMin(nums);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime())+",totalCount:"+totalCount);
		System.out.println(result);
	}
	public int findMin(int[] nums) {
       return find(nums,0,nums.length-1);
    }
    
    public int find(int[] nums, int l, int r) {
    	if(l == r)	{
    		return nums[l];
    	}
    	if(nums[l] == nums[r]) {
            return find(nums, l, r-1);
        }
        if(nums[l] < nums[r]) {
            return nums[l];
        }
        int mid = (l + r) / 2;
        return Math.min(find(nums,l,mid),find(nums,mid+1,r));
    }
}

