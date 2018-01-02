package com.wlw.leetcode2;

import java.util.Date;

import com.wlw.leetcode1.ParamUtil;

public class Q239_SlidingWindowMaximum {
	private static long totalCount = 0;
	public static void main(String[] args) {
		Q239_SlidingWindowMaximum test = new Q239_SlidingWindowMaximum();
		
		Date start = new Date();
		
		String testStr = ""+/**~{*/""
			+ "[1,3,-1,-3,5,3,6,7]"
		+ "\r\n"/**}*/;
		int[] nums = ParamUtil.str2IntArr(testStr);
		Object result = test.maxSlidingWindow(nums,1);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime())+",totalCount:"+totalCount);
		System.out.println(result);
		ParamUtil.printArr((int[])result);
	}
	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums.length<1)	{
			return new int[0];
		}
		int[] result = new int[nums.length-k+1];
		for(int i=0;i<nums.length-k+1;i++)	{
			int max=nums[i];
			for(int j=1;j<k;j++)	{
				if(nums[i+j]>max)	{
					max = nums[i+j];
				}
			}
			result[i]=max;
		}
        return result;
    }
}

