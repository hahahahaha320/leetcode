package com.wlw.leetcode;

import java.util.Date;

public class Q62_UniquePaths {

	public static void main(String[] args) {
		Q62_UniquePaths test = new Q62_UniquePaths();
		
		Date start = new Date();
		
		int result = test.uniquePaths(7,3);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public int uniquePaths(int m, int n) {
		int[] result = new int[m];
		for(int i=1;i<=n;i++)	{
			int temp = 0;
			result[m-1] = 1;
			for(int j=m-1;j>0;j--)	{
				temp = result[j-1];
				result[j-1]  = temp+result[j];
			}
		}
		return result[0];
    }
}

