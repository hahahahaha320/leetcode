package com.wlw.leetcode1;

import java.util.Date;

public class Q132_PalindromePartitioningII {

	public static void main(String[] args) {
		Q132_PalindromePartitioningII test = new Q132_PalindromePartitioningII();
		
		Date start = new Date();
		
		String str = "aabaacabbdd";
		Object result = test.minCut(str);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public int minCut(String s) {
		if(s == null || s.length() == 0 || s.length() == 1)	{
		    return 0;  
		}
		int[] min = new int[s.length() + 1];  
		int[][] dp = new int[s.length()][s.length()];
		for(int i=s.length()-1;i>=0;i--)	{
			min[i] = s.length() - i;  
			for(int j=i;j<s.length();j++)	{
				if(s.charAt(i) == s.charAt(j))	{
					if(j-i<2 || dp[i+1][j-1] == 1)	{
						dp[i][j] = 1;
						min[i] = Math.min(min[i], min[j+1]+1);  
					}
				}
			}
		}
		return min[0]-1;
    }
}

