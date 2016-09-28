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
		int n = obstacleGrid.length;
		int m = obstacleGrid[0].length;
		if(obstacleGrid[n-1][m-1] == 1)	{
			return 0;
		}
		int[] result = new int[m];
		boolean rightCanGo = true;
		for(int i=1;i<=n;i++)	{
			int temp = 0;
			result[m-1] = 1;
			if(obstacleGrid[n-i][m-1] == 1 || !rightCanGo)	{
				result[m-1] = 0;
				rightCanGo = false;
			}
			for(int j=m-1;j>0;j--)	{
				temp = result[j-1];
				if(obstacleGrid[n-i][j-1] == 1)	{
					result[j-1] = 0;
				} else {
					result[j-1]  = temp+result[j];
				}
			}
		}
		return result[0];
    }
}

