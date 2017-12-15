package com.wlw.leetcode2;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q140_WordBreakII {
	private static long totalCount = 0;
	public static void main(String[] args) {
		Q140_WordBreakII test = new Q140_WordBreakII();
		
		Date start = new Date();
		
		String str1 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		String testStr1 = ""+/**~{*/""
				+ "[\"a\",\"aa\",\"aaa\",\"aaaa\",\"aaaaa\",\"aaaaaa\",\"aaaaaaa\",\"aaaaaaaa\",\"aaaaaaaaa\",\"aaaaaaaaaa\"]"
			+ "\r\n"/**}*/;
		String str = "catsanddog";
		String testStr = ""+/**~{*/""
				+ "[\"cat\",\"cats\",\"and\",\"sand\",\"dog\"]"
			+ "\r\n"/**}*/;
		List<String> wordDict = ParamUtil.str2List(testStr);
		Object result = test.wordBreak(str,wordDict);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime())+",totalCount:"+totalCount);
		System.out.println(result);
	}
	public List<String> wordBreak(String s, List<String> wordDict) {
		List<String> result = new ArrayList<String>();
		List<String> array = new ArrayList<String>();
		Set<String> wordSet = new HashSet<String>();
		for(String word : wordDict)	{
			wordSet.add(word);
		}
		int[][] dp = new int[s.length()][s.length()];
		for(int i=0;i<s.length();i++)	{
			for(int j=i;j<s.length();j++)	{
				if(wordSet.contains(s.substring(i,j+1)))	{
					dp[i][j] = 1;
				}
			}
		}
//		dfs(s,0,dp,"",result);
		dfs2(s,0,dp,array,result);
		return result;
    }
	private String arr2Str(List<String> array)	{
		String result = "";
		for(int i=0;i<array.size();i++)	{
			result = result + array.get(i);
			if(i != array.size()-1)	{
				result = result + " ";
			}
		}
		return result;
	}
	private void dfs(String s,int begin,int[][] dp,String array,List<String> result)	{
		if(begin == s.length())	{
			result.add(array);
			return;
		}
		for(int i=begin;i<s.length();i++)	{
			if(dp[begin][i] == 1)	{
				array = array + s.substring(begin,i+1) + " ";
				dfs(s,i+1,dp, array,result);
			}
		}
	}
	private void dfs2(String s,int begin,int[][] dp,List<String> array,List<String> result)	{
		if(begin == s.length())	{
			result.add(arr2Str(array));
			return;
		}
		for(int i=begin;i<s.length();i++)	{
			if(dp[begin][i] == 1)	{
				List<String> temp = new ArrayList<String>(array);
				temp.add(s.substring(begin,i+1));
				dfs2(s,i+1,dp, temp,result);
			}
		}
	}
	
}

