package com.wlw.leetcode;

import java.util.Date;

public class Q63_UniquePathsII {

	public static void main(String[] args) {
		Q63_UniquePathsII test = new Q63_UniquePathsII();
		
		Date start = new Date();
		int[][] obstacleGrid = new int[][]{{0,0},{1,1},{0,0}};
		int result = test.uniquePathsWithObstacles(obstacleGrid);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		if(obstacleGrid[m-1][n-1] == 1)	{
			return 0;
		}
		int[] result = new int[n];
		boolean rightCanGo = true;
		for(int i=m-1;i>=0;i--)	{
			int temp = 0;
			result[n-1] = 1;
			if(obstacleGrid[i][n-1] == 1 || !rightCanGo)	{
				result[n-1] = 0;
				rightCanGo = false;
			}
			for(int j=n-1;j>0;j--)	{
				temp = result[j-1];
				if(obstacleGrid[i][j-1] == 1)	{
					result[j-1] = 0;
				} else {
					result[j-1]  = temp+result[j];
				}
			}
		}
		return result[0];
    }
}

