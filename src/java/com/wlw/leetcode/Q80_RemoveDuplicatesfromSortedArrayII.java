package com.wlw.leetcode;

import java.util.Date;

import com.wlw.leetcode.util.Util;

public class Q80_RemoveDuplicatesfromSortedArrayII {

	public static void main(String[] args) {
		Q80_RemoveDuplicatesfromSortedArrayII test = new Q80_RemoveDuplicatesfromSortedArrayII();
		
		Date start = new Date();
		
		int[] nums = new int[]{1,1,1,2,2,3};
		//SEE  ABCB
		Object result = test.removeDuplicates(nums);

		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
		Util.printArray(nums);
	}
	public int removeDuplicates(int[] nums) {
		int result = 1;
		int num = 1;
		int cur = 1;
        for(int i=1;i<nums.length;i++)	{
        	if(nums[i] == nums[i-1])	{
        		num++;
        	} else {
        		num = 1;
        	}
        	nums[cur] = nums[i];
        	if(num < 3)	{
        		result++;
        		cur++;
        	}
        }
        return result;
    }
}

