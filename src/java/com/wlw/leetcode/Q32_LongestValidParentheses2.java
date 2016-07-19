package com.wlw.leetcode;

import java.util.Date;

public class Q32_LongestValidParentheses2 {

	public static void main(String[] args) {
		Q32_LongestValidParentheses2 test = new Q32_LongestValidParentheses2();
		
		Date start = new Date();
		String str ="))))((()((";
		int result = test.longestValidParentheses(str);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public int longestValidParentheses(String s) {
		int length = s.length();
		StringBuffer sb = new StringBuffer(s);
		
		boolean changed;
		do	{
			changed = false;
			for(int i=0;i<length;i++)	{
				if(sb.charAt(i) == '(')	{
					int j=0;
					while(i+j < length-3 && sb.charAt(i+j+1) == '0'){
						j+=2;
					}
					if(i+j<length-1 && sb.charAt(i+j+1) == ')'){
						sb.setCharAt(i, '0');
						sb.setCharAt(i+j+1, '0');
						changed = true;
					}
				}
			}
		} while(changed);
		
		int max = 0;
		for(int i=0;i<length;i++)	{
			if(sb.charAt(i) == '0')	{
				int cur = 1;
				while(i<length-1 && sb.charAt(++i) == '0')	{
					cur++;
				}
				if(cur>max)	{
					max = cur;
				}
			}
		}
        return max;
    }
	
	
	public static void main1(String[] args) {
		String str = "(()(()()";
		Q32_LongestValidParentheses2 test = new Q32_LongestValidParentheses2();
		System.out.println(test.longestValidParentheses(str));
	}
	
}

