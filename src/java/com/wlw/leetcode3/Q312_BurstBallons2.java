package com.wlw.leetcode3;

import java.util.Date;

public class Q312_BurstBallons2 {

	public static void main(String[] args) {
		Q312_BurstBallons2 test = new Q312_BurstBallons2();
		
		Date start = new Date();
		
//		int[] nums = new int[]{3,1,5,8};
		int[] nums = new int[]{8,2,6,8,9,8,1,4,1,5,4,2,2,2,3,5,6,5};
		
		Object result = test.maxCoins(nums);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	
	public int maxCoins(int[] nums) {
		int len = nums.length;
		int[] newNums = new int[len+2];
		newNums[0] = newNums[len+1] = 1;
		for(int i=0;i<len;i++)	{
			newNums[i+1] = nums[i];
		}
		int[][] dp = new int[len+2][len+2];
		for(int round=1;round<=len;round++)	{
			for(int i=1;i+round<=len+1;i++)	{
				for(int m=i;m<=i+round-1;m++)	{
					dp[i][i+round-1] = Math.max(dp[i][i+round-1],
							dp[i][m-1]+dp[m+1][i+round-1]+newNums[m]*newNums[i-1]*newNums[i+round]);
				}
			}
			
		}
		return dp[1][len];
    }
}

