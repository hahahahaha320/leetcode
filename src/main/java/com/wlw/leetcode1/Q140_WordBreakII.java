package com.wlw.leetcode1;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.wlw.leetcode.util.ParamUtil;

public class Q140_WordBreakII {
	private static long totalCount = 0;
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Q140_WordBreakII test = new Q140_WordBreakII();
		
		Date start = new Date();
		
		String str1 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		String testStr1 = ""+/**~{*/""
				+ "[\"a\",\"aa\",\"aaa\",\"aaaa\",\"aaaaa\",\"aaaaaa\",\"aaaaaaa\",\"aaaaaaaa\",\"aaaaaaaaa\",\"aaaaaaaaaa\"]"
			+ "\r\n"/**}*/;
		String str2 = "catsanddog";
		String testStr2 = ""+/**~{*/""
				+ "[\"cat\",\"cats\",\"and\",\"sand\",\"dog\"]"
			+ "\r\n"/**}*/;
		
		String str = str1;
		String testStr = testStr1;
		List<String> wordDict = ParamUtil.str2List(testStr);
		Object result = test.wordBreak(str,wordDict);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime())+",totalCount:"+totalCount);
		System.out.println(result);
	}
	
	public List<String> wordBreak(String s, List<String> wordDict) {
		List<String> result = new ArrayList<String>();
		Set<String> wordSet = new HashSet<String>();
		for(String word : wordDict)	{
			wordSet.add(word);
		}
		if(!canWordBreak(s, wordSet))	{
			return result;
		}
		int[][] dp = new int[s.length()][s.length()];
		for(int i=0;i<s.length();i++)	{
			for(int j=i;j<s.length();j++)	{
				if(wordSet.contains(s.substring(i,j+1)))	{
					dp[i][j] = 1;
				}
			}
		}
		List<String> array = new ArrayList<String>();
		dfs(s,0,dp,array,result);
		return result;
    }
	public boolean canWordBreak(String s, Set<String> wordSet) {
        boolean[] result = new boolean[s.length()+1];
        result[s.length()] = true;
        for(int i=s.length()-1;i>=0;i--)	{
        	for(int j=i;j<s.length();j++)	{
        		if(wordSet.contains(s.substring(i,j+1)) && result[j+1])	{
        			result[i] = true;
        			break;
        		}
        	}
        }
        return result[0];
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
	private void dfs(String s,int begin,int[][] dp,List<String> array,List<String> result)	{
		if(begin == s.length())	{
			result.add(arr2Str(array));
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

