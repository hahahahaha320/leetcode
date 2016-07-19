package com.wlw.leetcode;

import java.util.Date;

public class Q38_CountandSay {

	public static void main(String[] args) {
		Q38_CountandSay test = new Q38_CountandSay();
		
		Date start = new Date();
		
		String result = test.countAndSay(5);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public String countAndSay(int n) {
		String curStr = "1";
		if(n == 1)	{
			return curStr;
		}
		for(int i=2;i<=n;i++)	{
			String newStr = "";
			char curChar = curStr.charAt(0);
			int charNum = 1;
			for(int j=1;j<=curStr.length();j++)	{
				if(j == curStr.length())	{
					newStr = newStr+charNum+curChar;
				} else if(curStr.charAt(j) == curChar)	{
					charNum++;
				} else {
					newStr = newStr+charNum+curChar;
					curChar = curStr.charAt(j);
					charNum = 1;
				}
			}
			curStr = newStr;
			System.out.println(i + " : " + curStr);
		}
        return curStr;
    }
}

