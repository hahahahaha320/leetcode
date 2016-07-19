package com.wlw.leetcode;

import java.util.Date;

public class Q26_RemoveDuplicatesfromSortedArray {

	public static void main(String[] args) {
		Q26_RemoveDuplicatesfromSortedArray test = new Q26_RemoveDuplicatesfromSortedArray();
		 
		Date start = new Date();
		
		int[] nums = new int[]{1,1,2,2,2,2,2,3,4,7,7,7,7,7,7,8,9};
		int result = test.removeDuplicates(nums);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		for(int i=0;i<result;i++)	{
			System.out.println(nums[i]+",");
		}
		//System.out.println(result);
	}
	public int removeDuplicates(int[] nums) {
		int length = nums.length;
        if(length<=1)	{
        	return length;
        }
		
        int nextSavePos = 1;
		for(int i=1;i<length;i++)	{
			if(nums[i]>nums[nextSavePos-1])	{
				nums[nextSavePos] = nums[i];
				nextSavePos++;
			} 
		}
		return nextSavePos;
    }
}

