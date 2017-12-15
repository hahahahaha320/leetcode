package com.wlw.leetcode2;

import java.util.Date;

public class Q00_Common {
	private static long totalCount = 0;
	public static void main(String[] args) {
		Q00_Common test = new Q00_Common();
		
		Date start = new Date();
		
		String str = "abc";
		Object result = test.longestPalindrome(str);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime())+",totalCount:"+totalCount);
		System.out.println(result);
	}
	public String longestPalindrome(String str) {
        
		
		return "";
    }
}

