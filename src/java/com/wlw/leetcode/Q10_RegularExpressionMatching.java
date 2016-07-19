package com.wlw.leetcode;

import java.util.Date;

public class Q10_RegularExpressionMatching {

	public static void main(String[] args) {
		Q10_RegularExpressionMatching test = new Q10_RegularExpressionMatching();
		Date start = new Date();
//		String s = "a";
//		String p = ".*..a*";
		String s = "aa";
		String p = ".";
		boolean result = test.isMatch(s, p);
		System.out.println(result);
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
	}
	public boolean isMatch(String s, String p) {
		if(p.length()==0)	{
			return s.length() == 0;
		}
		char first = p.charAt(0);
		char next = 0;
		if(p.length() >= 2)	{
			next = p.charAt(1);
		}
		if(next==0)	{
			return s.length() ==1 && first == '.' || s.equals(first+"");
		}
		if(next != '*')	{
			if(s.length() == 0)	{
				return false;
			} else if(first == s.charAt(0) || first == '.')	{
				return isMatch(s.substring(1), p.substring(1));
			} else {
				return false;
			}
		}else {
			boolean ok = isMatch(s,p.substring(2));
			if(ok)	{
				return true;
			}else {
				for(int i=0;i<s.length();i++)	{
					if(first != '.' && s.charAt(i) != first)	{
						return false;
					} else {
						boolean result = isMatch(s.substring(i+1),p.substring(2));
						if(result)	{
							return true;
						}
					}
				}
				return false;
			}
		}
	}
}

