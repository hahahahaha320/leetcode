package com.wlw.leetcode;

import java.util.Date;

public class Q45_JumpGameII {

	public static void main(String[] args) {
		Q45_JumpGameII test = new Q45_JumpGameII();
		
		Date start = new Date();
		
		int[] nums = new int[]{2,3,1,1,4,2,3,1,2,3,1};
		int result = test.jump(nums);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public int jump(int[] nums) {
		int ret = 0;
		int curMax = 0;
		int curRch = 0;
		for (int i = 0; i < nums.length; i++) {
			if (curRch < i) {
				System.out.println(i+":" +  curRch);
				ret++;
				curRch = curMax;
			}
			curMax = Math.max(curMax, nums[i] + i);
			System.out.println(i+":" +  curRch + "," + curMax);
		}
		return ret;
	}
}

