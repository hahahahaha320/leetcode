package com.wlw.leetcode;

import java.util.Date;

public class Q91_DecodeWays2 {

	public static void main(String[] args) {
		Q91_DecodeWays2 test = new Q91_DecodeWays2();
		
		Date start = new Date();
		String str = "9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253";
//		String str = "110";
		Object result = test.numDecodings(str);

		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public int numDecodings(String s) {
		if(s.startsWith("0") || s.length() == 0)	{
	      	return 0;
	    }
		int len = s.length();
		int[] result = new int[len+1];
		result[0] = 1;
		result[1] = 1;
		for(int i=1;i<s.length();i++)	{
			char c = s.charAt(i);
			int pre1 = 0;
			if(c != '0')	{
				pre1 = result[i];
			}
			int pre2 = 0;
			int preChar = s.charAt(i-1);
			if(preChar!='0' && (preChar == '1' ||preChar == '2' && c <= '6'))	{
				pre2 = result[i-1];
			}
			int cur = pre1+pre2;
			if(cur == 0)	{
				return 0;
			}
			result[i+1] = cur;
		}
		return result[len];
	}
}

