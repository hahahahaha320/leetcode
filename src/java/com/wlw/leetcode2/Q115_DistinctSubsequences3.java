package com.wlw.leetcode2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Q115_DistinctSubsequences3 {

	public static void main(String[] args) {
		Q115_DistinctSubsequences3 test = new Q115_DistinctSubsequences3();
		
		Date start = new Date();
		
//		String s = "rabbbt";
//		String t = "rabbt";
//		String s = "bccbcdcabadabddbccaddcbabbaaacdba";
//		String t = "bccbbdc";
//		String s = "abcde";
//		String t = "abc";
		String s = "daacaedaceacabbaabdccdaaeaebacddadcaeaacadbceaecddecdeedcebcdacdaebccdeebcbdeaccabcecbeeaadbccbaeccbbdaeadecabbbedceaddcdeabbcdaeadcddedddcececbeeabcbecaeadddeddccbdbcdcbceabcacddbbcedebbcaccac";
		String t = "ceadbaa";
		
		Object result = test.numDistinct(s,t);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public int numDistinct(String s, String t) {
		List<Integer> result = new ArrayList<Integer>();
		result.add(0);
		geneChooseList(s,t,result);
		return result.get(0);
    }
	private void geneChooseList(String str,String target,List<Integer> result)	{
		for(int i=0;i<str.length();i++)	{
			if(str.charAt(i) == target.charAt(0))	{
				if(target.length()==1)	{
					result.set(0,result.get(0)+1);
				} else {
					geneChooseList(str.substring(i+1), target.substring(1),result);
				}
			}
		}
	}
}

