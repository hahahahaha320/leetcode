package com.wlw.leetcode;

import java.util.Date;

public class Q76_MinimumWindowSubstring2 {

	public static void main(String[] args) {
		Q76_MinimumWindowSubstring2 test = new Q76_MinimumWindowSubstring2();
		
		Date start = new Date();
		
//		Object result = test.minWindow("ADOBECODEBANC","ABC");
		Object result = test.minWindow("A","A");

		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
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
		int start = 0,end=-1;
		
		while(true)	{
			if(needNum == 0)	{
				start++;
				int pos = s.charAt(start-1) - 'A';
				if(array[pos] != Integer.MIN_VALUE)	{
					array[pos]++;
					if(array[pos] > 0)	{
						needNum++;
					}
				}
			} else {
				if(end == s.length()-1)	{
					break;
				}
				end++;
				
				int pos = s.charAt(end) - 'A';
				if(array[pos] != Integer.MIN_VALUE)	{
					array[pos]--;
					if(array[pos] >= 0)	{
						needNum--;
					}
				}
			}
			if(needNum==0 && end-start < resultEnd-resultStart)	{
				resultEnd = end;
				resultStart = start;
			}
		}
		if(resultStart+resultEnd>=0)	{
			return s.substring(resultStart, resultEnd+1);
		}
        return "";
    }
}

