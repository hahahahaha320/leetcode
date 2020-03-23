package com.wlw.leetcode;

import java.util.Date;

public class Q35_SearchInsertPosition {

	public static void main(String[] args) {
		Q35_SearchInsertPosition test = new Q35_SearchInsertPosition();
		
		Date start = new Date();
		
		int[] nums = new int[]{1,3,5,7,10,20};
		int result = test.searchInsert(nums,12);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public int searchInsert(int[] nums, int target) {
		if(target <= nums[0])	{
			return 0;
		} 
		if(target == nums[nums.length-1])	{
			return nums.length-1;
		} 
		if(target > nums[nums.length-1])	{
			return nums.length;
		}
		int start = 0;
		int end = nums.length-1;
		int media = 0;
		while(true)	{
			media = (start+end)/2;
			if(nums[media] == target)	{
				return media;
			} else if(nums[media] > target && nums[media-1] < target) {
				return media;
			} else if(nums[media] < target && nums[media+1] > target) {
				return media+1;
			} else if(nums[media] > target)	{
				end = media-1;
			} else if(nums[media] < target)	{
				start = media+1;
			}
		}
    }
}

