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
		int[] result = new int[n];
		result[n-1] = 1;
		for(int i=m-1;i>=0;i--)	{
			for(int j=n-2;j>=0;j--)	{
				result[j]  = result[j]+result[j+1];
			}
		}
		return result[0];
    }
}

