package com.wlw.leetcode;

import java.util.Date;

public class Q53_MaximumSubarray {
	public Q53_MaximumSubarray(){
		
	}
	private int[] nums = new int[]{-2,-1,-3,-4,-1,-2,-1,-5,-4};
	
	public static void main(String[] args) {
		Q53_MaximumSubarray test = new Q53_MaximumSubarray();
		
		Date start = new Date();
		
		
		int result = test.maxSubArray(test.nums);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public int maxSubArray(int[] nums) {
		int maxTotal=nums[0];
		int curTotal=0;
		for(int i=0;i<nums.length;i++)	{
			curTotal=curTotal+nums[i];
			if(curTotal>maxTotal)	{
				maxTotal = curTotal;
			}
			if(curTotal<0)	{
				curTotal=0;	
			}
		}
		return maxTotal;
    }
}

