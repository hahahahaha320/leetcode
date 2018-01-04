package com.wlw.leetcode2;

import java.util.Date;

import com.wlw.leetcode.util.ParamUtil;

public class Q239_SlidingWindowMaximum2 {
	private static long totalCount = 0;
	public static void main(String[] args) {
		Q239_SlidingWindowMaximum2 test = new Q239_SlidingWindowMaximum2();
		
		Date start = new Date();
		
		String testStr = ""+/**~{*/""
			+ "[3,4,5,6]"
		+ "\r\n"/**}*/;
		int[] nums = ParamUtil.str2IntArr(testStr);
		Object result = test.maxSlidingWindow(nums,4);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime())+",totalCount:"+totalCount);
		System.out.println(result);
		ParamUtil.printArr((int[])result);
	}
	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums.length<1)	{
			return new int[0];
		}
	    final int[] max_left = new int[nums.length];
	    final int[] max_right = new int[nums.length];
	    max_left[0] = nums[0];
	    max_right[nums.length - 1] = nums[nums.length - 1];
	    for (int i = 1; i < nums.length; i++) {
	        max_left[i] = (i % k == 0) ? nums[i] : Math.max(max_left[i - 1], nums[i]);
	        final int j = nums.length - i - 1;
	        max_right[j] = (j % k == 0) ? nums[j] : Math.max(max_right[j + 1], nums[j]);
	    }
	    final int[] sliding_max = new int[nums.length - k + 1];
	    for (int i = 0, j = 0; i + k <= nums.length; i++) {
	        sliding_max[j++] = Math.max(max_right[i], max_left[i + k - 1]);
	    }
	    return sliding_max;
	}
}

