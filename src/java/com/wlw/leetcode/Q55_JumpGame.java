package com.wlw.leetcode;

import java.util.Date;

public class Q55_JumpGame {

	public static void main(String[] args) {
		Q55_JumpGame test = new Q55_JumpGame();
		
		Date start = new Date();
		
//		int[] nums = {2,3,1,1,4};
		int[] nums = {3,2,1,0,4};
		boolean result = test.canJump(nums);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public boolean canJump(int[] nums) {
		int curMax = 0;
		for (int i = 0; i < nums.length; i++) {
			if (curMax < i) {
				return false;
			}
			curMax = Math.max(curMax, nums[i] + i);
		}
		return true;
    }
}

