package com.wlw.leetcode1;

import java.util.Date;

public class Q174_DungeonGame {
	private static long totalCount = 0;
	public static void main(String[] args) {
		Q174_DungeonGame test = new Q174_DungeonGame();
		
		Date start = new Date();
		
		
		
//		int[][] dungeon = new int[][]{
//			{-2,-3,3},
//			{-5,-10,1},
//			{10,30,-5}
//		};
		int[][] dungeon = new int[][]{
			{-5}
		};
		Object result = test.calculateMinimumHP(dungeon);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime())+",totalCount:"+totalCount);
		System.out.println(result);
	}
	public int calculateMinimumHP(int[][] dungeon) {
		int m = dungeon.length,n=dungeon[0].length;
		int[][] dp = new int[m+1][n+1];
		for(int i=m;i>=0;i--)	{
			for(int j=n;j>=0;j--)	{
				if(i==m||j==n) 	{
					if(i==m && j==n-1)	{
						dp[i][j]=1;
					} else {
						dp[i][j]=Integer.MAX_VALUE;
					}
					continue;
				}
				dp[i][j] =  Math.min(dp[i][j+1],dp[i+1][j])-dungeon[i][j];
				if(dp[i][j] <= 0)	{
					dp[i][j] = 1;
				}
			}
		}
        return dp[0][0];
    }
}

