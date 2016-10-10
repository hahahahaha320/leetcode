package com.wlw.leetcode;

import java.util.Date;

public class Q76_MinimumWindowSubstring2 {

	public static void main(String[] args) {
		Q76_MinimumWindowSubstring2 test = new Q76_MinimumWindowSubstring2();
		
		Date start = new Date();
		
//		Object result = test.minWindow("ADOBECODEBANC","ABC");
		Object result = test.minWindow("abc","b");
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
		System.out.println("time2:"+ time);
	}
	private static long time=0;
	public String minWindow(String s, String t) {
		int resultStart = -99999;
		int resultEnd = 0;
		
		int[] array = new int[60];
		int needNum = t.length();
		for (int j = 0; j < needNum; j++) {
			array[t.charAt(j) - 'A']++;
		}
		for (int j = 0; j < 60; j++) {
			if(array[j] <= 0)	{
				array[j] = Integer.MIN_VALUE;
			}
		}
		int start = 0,end=0;
		while(end < s.length() || start < s.length())	{
//			String a = "";
//			if(end >= s.length())	{
//				a = s.substring(start, s.length());
//			} else {
//				a = s.substring(start, end+1);
//			}
			if(needNum == 0)	{
				if(end-start <= resultEnd-resultStart)	{
					resultEnd = end;
					resultStart = start;
				}
				int pos = s.charAt(start) - 'A';
				if(array[pos] != Integer.MIN_VALUE)	{
					array[pos]++;
					if(array[pos] > 0)	{
						needNum++;
					}
				}
				start++;
			} else {
				
				if(end > s.length()-1)	{
					break;
				}
				int pos = s.charAt(end) - 'A';
				
				if(array[pos] != Integer.MIN_VALUE)	{
					array[pos]--;
					if(array[pos] >= 0)	{
						needNum--;
						if(needNum==0 && end-start < resultEnd-resultStart)	{
							resultEnd = end;
							resultStart = start;
						}
					}
				}
				end++;
				
			}
		}
		if(resultStart+resultEnd>=0)	{
			if(resultEnd >= s.length())	{
				return s.substring(resultStart,s.length());
			}
			return s.substring(resultStart, resultEnd+1);
		}
        return "";
    }
	
	public boolean contains(String A, String B) {
		
		if(A.length()<B.length())	{
			return false;
		}
		int[] array = new int[60];
		for (int i = 0; i < A.length(); i++) {
			array[A.charAt(i) - 'A'] += 1;
		}
		for (int j = 0; j < B.length(); j++) {
			array[B.charAt(j) - 'A'] -= 1;
			if(array[B.charAt(j) - 'A'] < 0) return false;
		}
		return true;
	}
}

