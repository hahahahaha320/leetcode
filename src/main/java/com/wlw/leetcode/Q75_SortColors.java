package com.wlw.leetcode;

import java.util.Date;

import com.wlw.leetcode.util.Util;

public class Q75_SortColors {

	public static void main(String[] args) {
		Q75_SortColors test = new Q75_SortColors();
		
		Date start = new Date();
		
		int[] nums = new int[]{0,1,2,0,2};
		test.sortColors(nums);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		Util.printArray(nums);
	}
	public void sortColors(int[] nums) {
        int zeroNum = 0;
        int oneNum = 0;
        for(int num : nums)	{
        	if(num == 0)	{
        		zeroNum++;
        	} else if(num == 1)	{
        		oneNum++;
        	}
        }
        for(int i=0;i<nums.length;i++)	{
        	if(i<zeroNum)	{
        		nums[i]=0;
        	} else if(i<zeroNum+oneNum)	{
        		nums[i]=1;
        	} else {
        		nums[i]=2;
        	}
        }
    }
}

