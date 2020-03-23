package com.wlw.leetcode.test;

import java.util.Date;

public class Solution1 {
	private static long totalCount = 0;
	public static void main(String[] args) {
		Solution1 test = new Solution1();
		
		Date start = new Date();
		
		String str = "mRZ";
		Object result = test.detectCapitalUse(str);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime())+",totalCount:"+totalCount);
		System.out.println(result);
	}
	public boolean detectCapitalUse(String word) {
        if(word.length() == 1)	{
        	return true;
        }
        boolean isFirstCapital = word.charAt(0) <= 'Z';
        boolean isSecondCapital = word.charAt(1) <= 'Z';
        if(!isFirstCapital && isSecondCapital)	{
        	return false;
        }
        if(word.length() == 2 )	{
        	if(isFirstCapital)	{
        		return true;
        	}
        	if(!isSecondCapital)	{
        		return true;
        	}
        	return false;
        }
        for(int i=2;i<word.length();i++)	{
        	boolean isCapital = word.charAt(i) <= 'Z';
        	if(isCapital != isSecondCapital)	{
        		return false;
        	}
        }
        return true;
	}
}
