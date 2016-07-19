package com.wlw.leetcode;

import java.util.Date;

public class Q27_RemoveElement {

	public static void main(String[] args) {
		Q27_RemoveElement test = new Q27_RemoveElement();
		
		Date start = new Date();
		
		int[] nums = new int[]{3,4,5};
		int result = test.removeElement(nums,2);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		for(int i=0;i<result;i++)	{
			System.out.println(nums[i]+",");
		}
	}
	public int removeElement(int[] nums, int val) {
		int length = nums.length;
		int nextSavePos = 0;
		for(int i=0;i<length;i++)	{
			if(nums[i]!=val)	{
				nums[nextSavePos] = nums[i];
				nextSavePos++;
			} 
		}
		return nextSavePos;
    }
}

