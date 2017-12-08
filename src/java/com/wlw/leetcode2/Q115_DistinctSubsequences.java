package com.wlw.leetcode2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Q115_DistinctSubsequences {

	public static void main(String[] args) {
		Q115_DistinctSubsequences test = new Q115_DistinctSubsequences();
		
		Date start = new Date();
		
//		String s = "rabbbit";
//		String t = "rabbit";
//		String s = "bccbcdcabadabddbccaddcbabbaaacdba";
//		String t = "bccbbdc";
		String s = "abcde";
		String t = "abc";
		
		Object result = test.numDistinct(s,t);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public int numDistinct(String s, String t) {
		int[] nums = new int[s.length()];
		for(int i=0;i<nums.length;i++)	{
			nums[i] = i;
		}
		List<Integer> subResult = new ArrayList<Integer>();
		List<List<Integer>> fullResult = new ArrayList<List<Integer>>();
		geneChooseList(nums, 0,nums.length-1,t.length(),subResult,fullResult);
		
		for(List<Integer> a : fullResult)	{
			System.out.println(a);
		}
		
		
		int result = 0;
		/*
		char[] strArray = new char[s.length()];
		for(int i=0;i<s.length();i++)	{
			strArray[i] = s.charAt(i);
		}
		char[] targetArray = new char[t.length()];
		for(int i=0;i<t.length();i++)	{
			targetArray[i] = t.charAt(i);
		}
		
		for(List<Integer> posList : fullResult)	{
			int sameNum = 0;
			for(int i=0;i<targetArray.length;i++)	{
				if(strArray[posList.get(i)] != targetArray[i])	{
					break;
				}
				sameNum++;
			}
			if(sameNum == t.length())	{
				result++;
			}
		}
		*/
		return result;
    }
	private void geneChooseList(int[] list,int from,int to,int num,
			List<Integer> subResult,List<List<Integer>> fullResult)	{
		if(num == 0)	{
			List<Integer> result = new ArrayList<Integer>();
			result.addAll(subResult);
			fullResult.add(result);
			return;
		}
		if(to-from+1 < num)	{
			return;
		}
		subResult.add(list[from]);
		geneChooseList(list,from+1,to,num-1,subResult,fullResult);
		
		subResult.remove(subResult.size()-1);
		geneChooseList(list,from+1,to,num,subResult,fullResult);
	}
}

