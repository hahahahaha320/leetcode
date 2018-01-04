package com.wlw.leetcode1;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.wlw.leetcode.util.ParamUtil;

public class Q140_WordBreakII2 {
	private static long totalCount = 0;
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Q140_WordBreakII2 test = new Q140_WordBreakII2();
		
		Date start = new Date();
		
		String str1 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		String testStr1 = ""+/**~{*/""
				+ "[\"a\",\"aa\",\"aaa\",\"aaaa\",\"aaaaa\",\"aaaaaa\",\"aaaaaaa\",\"aaaaaaaa\",\"aaaaaaaaa\",\"aaaaaaaaaa\"]"
			+ "\r\n"/**}*/;
		String str2 = "catsanddog";
		String testStr2 = ""+/**~{*/""
				+ "[\"cat\",\"cats\",\"and\",\"sand\",\"dog\"]"
			+ "\r\n"/**}*/;
		
		String str = str2;
		String testStr = testStr2;
		List<String> wordDict = ParamUtil.str2List(testStr);
		Object result = test.wordBreak(str,wordDict);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime())+",totalCount:"+totalCount);
		System.out.println(result);
	}
	
	public List<String> wordBreak(String s, List<String> wordDict) {
	    return dfs(s, wordDict, new HashMap<String, LinkedList<String>>());
	}       
	// DFS function returns an array including all substrings derived from s.
	List<String> dfs(String s, List<String> wordDict, HashMap<String, LinkedList<String>>map) {
	    if (map.containsKey(s)) 
	        return map.get(s);
	        
	    LinkedList<String>res = new LinkedList<String>();     
	    if (s.length() == 0) {
	        res.add("");
	        return res;
	    }               
	    for (String word : wordDict) {
	        if (s.startsWith(word)) {
	            List<String>sublist = dfs(s.substring(word.length()), wordDict, map);
	            for (String sub : sublist) 
	                res.add(word + (sub.isEmpty() ? "" : " ") + sub);               
	        }
	    }       
	    map.put(s, res);
	    return res;
	}
	
}

