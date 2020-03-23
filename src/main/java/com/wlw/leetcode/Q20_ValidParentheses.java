package com.wlw.leetcode;

import java.util.Date;
import java.util.Stack;

public class Q20_ValidParentheses {
	
	public static void main(String[] args) {
		Q20_ValidParentheses test = new Q20_ValidParentheses();
		
		Date start = new Date();
		
		boolean result = test.isValid("])");
		System.out.println(result);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		
	}
	
	public boolean isValid(String s) { 
		Stack<Character> sk = new Stack<Character>();
		if(s.length() % 2 == 1)	{
			return false;
		}
		for(int i=0;i<s.length();i++)	{
			char c = s.charAt(i);
			if(isLeft(c))	{
				sk.push(c);
			} else {
				if(sk.size() == 0 || !isMatch(sk.pop(),c))	{
					return false;
				}
			}
		}
		return sk.size() == 0;
    }
	private boolean isLeft(char c)	{
		switch (c) {
		case '{': return true;
		case '[': return true;
		case '(': return true;
		case '}': return false;
		case ']': return false;
		case ')': return false;
		default: return false;
		}
	}
	private boolean isMatch(char c1,char c2)	{
		switch (c1) {
		case '{': return c2=='}';
		case '[': return c2==']';
		case '(': return c2==')';
		default: return false;
		}
	}
}
