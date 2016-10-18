package com.wlw.leetcode;

import java.util.Arrays;
import java.util.Date;

public class Q87_ScrambleString {

	public static void main(String[] args) {
		Q87_ScrambleString test = new Q87_ScrambleString();
		
		Date start = new Date();
		
		Object result = test.isScramble("great","reatg");
//		Object result = test.isScramble("abcdefghijklmnopq","efghijklmnopqcadb");
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public boolean isScramble(String s1, String s2) {
		int len = s1.length();
		if(len != s2.length())	{
			return false;
		}
		if(s1.equals(s2))	{
			return true;
		}
		if(!isSameCharset(s1, s2))	{
			return false;
		}
        for(int i=1;i<len;i++)	{
        	if(isScramble(s1.substring(0,i), s2.substring(0,i))
        			&& isScramble(s1.substring(i,len), s2.substring(i,len))
        		|| isScramble(s1.substring(0,i), s2.substring(len-i,len))
    			&& isScramble(s1.substring(i,len), s2.substring(0,len-i))
        			)	{
        		return true;
        	}
        }
        return false;
    }
	private boolean isSameCharset(String s1, String s2){
		byte[] arr1 = s1.getBytes();
		Arrays.sort(arr1);
		s1 = new String(arr1);
		byte[] arr2 = s2.getBytes();
		Arrays.sort(arr2);
		s2 = new String(arr2);
		return s1.equals(s2);
	}
}

