package com.wlw.leetcode;

import java.util.Date;

public class Q76_MinimumWindowSubstring {

	public static void main(String[] args) {
		Q76_MinimumWindowSubstring test = new Q76_MinimumWindowSubstring();
		
		Date start = new Date();
		
		Object result = test.minWindow("ADOBECODEBANC","ABC");
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public String minWindow(String s, String t) {
        return "";
    }
}

