package com.wlw.leetcode;

import java.util.Date;

public class Q44_WildcardMatching {

	public static void main(String[] args) {
		Q44_WildcardMatching test = new Q44_WildcardMatching();
		Date start = new Date();
		String s = "aaaabaabaabbbabaabaabbbbaabaaabaaabbabbbaaabbbbbbabababbaabbabbbbaababaaabbbababbbaabbbaabbaaabbbaabbbbbaaaabaaabaabbabbbaabababbaabbbabababbaabaaababbbbbabaababbbabbabaaaaaababbbbaabbbbaaababbbbaabbbbb";
		String p = "**a*b*b**b*b****bb******b***babaab*ba*a*aaa***baa****b***bbbb*bbaa*a***a*a*****a*b*a*a**ba***aa*a**a*";
		boolean result = test.isMatch(s, p);
		System.out.println(result);
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println("1".substring(1));
	}
	public boolean isMatch(String s, String p) {
		//去掉重复的*
		p=p.replaceAll("\\*{2,}", "\\*");
		if(p.length()==0)	{
			return s.length() == 0;
		}
		//先从后面判断非*情况的简单情况
		for(int i=p.length()-1;i>=0;i--)	{
			if(p.charAt(i) == '*')	{
				break;
			}
			if(p.charAt(i) != '?' && s.length()>=(p.length()-i) && p.charAt(i) != s.charAt(s.length()-(p.length()-i)))	{
				return false;
			}
		}
		String[] sa = p.split("\\*|\\?");
		for(String a : sa)	{
			if(!s.contains(a)){
				return false;
			}
		}
		
		if(p.charAt(0) != '*' && p.charAt(0) != '?')	{
			return s.length() > 0 && s.charAt(0) == p.charAt(0)  && isMatch(s.substring(1),p.substring(1));
		} else if(p.charAt(0) == '?')	{
			return s.length() > 0 && isMatch(s.substring(1),p.substring(1));
		} else if(p.charAt(0) == '*')	{
			if(p.length() == 1)	{
				return true;
			}
			for(int i=0;i<s.length();i++)	{
				if(isMatch(s.substring(i),p.substring(1)))	{
					return true;
				}
			}
		}
		return false;
	}
}

