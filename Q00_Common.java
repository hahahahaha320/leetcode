package com.wlw.leetcode;

import java.util.Date;

public class Q00_Common {

	public static void main(String[] args) {
		Q00_Common test = new Q00_Common();
		
		Date start = new Date();
		
		String str = "abc";
		Object result = test.longestPalindrome(str);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public String longestPalindrome(String str) {
        
		
		return "";
    }
}

