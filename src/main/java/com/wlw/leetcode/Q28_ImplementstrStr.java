package com.wlw.leetcode;

import java.util.Date;

public class Q28_ImplementstrStr {

	public static void main(String[] args) {
		Q28_ImplementstrStr test = new Q28_ImplementstrStr();
		
		Date start = new Date();
		
		int result = test.strStr("abc22","abc");
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public int strStr(String haystack, String needle) {
        int length = needle.length();
		for(int i=0;i<=haystack.length()-length;i++)	{
			String sub = haystack.substring(i,i+length);
			if(sub.equals(needle))	{
				return i;
			}
		}
		return -1;
    }
}

