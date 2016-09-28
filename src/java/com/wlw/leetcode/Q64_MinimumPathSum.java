package com.wlw.leetcode;

import java.util.Date;

public class Q64_MinimumPathSum {

	public static void main(String[] args) {
		Q64_MinimumPathSum test = new Q64_MinimumPathSum();
		
		Date start = new Date();
		
		int[][] grid = new int[][]{{0,0},{1,1},{0,0}};
		int result = test.minPathSum(grid);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public int minPathSum(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int[] result = new int[m];
		for(int i=0;i<m;i++)	{
			result[i] = Integer.MAX_VALUE;
		}
		for(int i=0;i<n;i++)	{
			int temp = 0;
			result[m-1] = 1;
			for(int j=m-1;j>=0;j--)	{
				temp = result[j-1];
				result[j-1]  = result[j]+Math.min(temp, b);
			}
		}
		return result[0];
    }
}

