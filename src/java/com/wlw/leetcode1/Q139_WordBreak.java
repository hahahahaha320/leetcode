package com.wlw.leetcode1;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.wlw.leetcode.util.ParamUtil;

public class Q139_WordBreak {
	private static long totalCount = 0;
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Q139_WordBreak test = new Q139_WordBreak();
		
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
	public boolean wordBreak(String s, List<String> wordDict) {
		Set<String> wordSet = new HashSet<String>();
		for(String word : wordDict)	{
			wordSet.add(word);
		}
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
}

