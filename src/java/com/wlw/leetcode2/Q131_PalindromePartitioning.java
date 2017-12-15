package com.wlw.leetcode2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Q131_PalindromePartitioning {

	public static void main(String[] args) {
		Q131_PalindromePartitioning test = new Q131_PalindromePartitioning();
		
		Date start = new Date();
		
		String str = "ababababababababababababcbabababababababababababa";
		Object result = test.partition(str);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<List<String>>();
		List<String> array = new ArrayList<String>();
		if(s == null || s.length() == 0)	{
			result.add(array);  
		    return result;  
		}
		int[][] dp = new int[s.length()][s.length()];
		//calculater all palindrome substring by dp
		for(int i=s.length()-1;i>=0;i--)	{
			for(int j=i;j<s.length();j++)	{
				if(i==j)	{
					dp[i][j] = 1;
				} else {
					if(s.charAt(i) == s.charAt(j))	{
						if(j==i+1 || dp[i+1][j-1] == 1)	{
							dp[i][j] = 1;
						}
					}
				}
			}
		}
		dfs(s,0,dp,array,result);
		return result;
    }
	private void dfs(String s,int begin,int[][] dp,List<String> array,List<List<String>> result)	{
		if(begin == s.length())	{
			result.add(array);
			return;
		}
		for(int i=begin;i<s.length();i++)	{
			if(dp[begin][i] == 1)	{
				List<String> temp = new ArrayList<String>(array);
				temp.add(s.substring(begin,i+1));
				dfs(s,i+1,dp, temp,result);
			}
		}
	}
}

