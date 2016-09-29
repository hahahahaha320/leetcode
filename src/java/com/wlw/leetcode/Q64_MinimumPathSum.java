package com.wlw.leetcode;

import java.util.Date;

public class Q64_MinimumPathSum {

	public static void main(String[] args) {
		Q64_MinimumPathSum test = new Q64_MinimumPathSum();
		
		Date start = new Date();
		
		int[][] grid = new int[][]{{1,2,3},{4,5,6}};
		int result = test.minPathSum(grid);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[] result = new int[n];
		result[n-1] = grid[m-1][n-1];
		for(int i=n-2;i>=0;i--)	{
			result[i] = result[i+1]+grid[m-1][i];
		}
		for(int i=m-2;i>=0;i--)	{
			result[n-1] = grid[i][n-1]+result[n-1];
			for(int j=n-2;j>=0;j--)	{
				result[j] = grid[i][j]+Math.min(result[j],result[j+1]);
			}
		}
		return result[0];
    }
}

