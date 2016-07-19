package com.wlw.leetcode;

import java.util.Date;

public class Q32_LongestValidParentheses {

	public static void main(String[] args) {
		Q32_LongestValidParentheses test = new Q32_LongestValidParentheses();
		
		Date start = new Date();
		
		String str = "((())())(()))(()()(()(()))(()((((()))))))((()())()))()()(()(((((()()()())))()())(()()))((((((())))((()))()()))))(()))())))()))()())((()()))))(()(((((())))))()((()(()(())((((())(())((()()(()())))())(()(())()()))())(()()()))()(((()())(((()()())))(((()()()))(()()))()))()))))))())()()((()(())(()))()((()()()((())))()(((()())(()))())())))(((()))))())))()(())))()())))())()((()))((()))()))(((())((()()()(()((()((())))((()()))())(()()(()))))())((())))(()))()))))))()(()))())(()())))))(()))((())(()((())(((((()()()(()()())))(()())()((()(()()))(()(())((()((()))))))))(()(())()())()(()(()(()))()()()(()()())))(())(()((((()()))())))(())((()(())())))))())()()))(((())))())((()(()))(()()))((())(())))))(()(()((()((()()))))))(()()()(()()()(()(())()))()))(((()(())()())(()))())))(((()))())(()((()))(()((()()()(())()(()())()(())(()(()((((())()))(((()()(((()())(()()()(())()())())(()(()()((()))))()(()))))(((())))()()))(()))((()))))()()))))((((()(())()()()((()))((()))())())(()((()()())))))))()))(((()))))))(()())))(((()))((()))())))(((()(((())))())(()))))(((()(((((((((((((())(((()))((((())())()))())((((())(((())))())(((()))))()())()(())())(()))))()))()()()))(((((())()()((()))())(()))()()(()()))(())(()()))()))))(((())))))((()()(()()()()((())((((())())))))((((((()((()((())())(()((()))(()())())())(()(())(())(()((())((())))(())())))(()()())((((()))))((()(())(()(()())))))))))((()())()()))((()(((()((()))(((((()()()()()(()(()((()(()))(()(()((()()))))()(()()((((((()((()())()))((())()()(((((()(()))))()()((()())((()())()(())((()))()()(()))";
		int result = test.longestValidParentheses(str);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public int longestValidParentheses(String s) {
		int length = s.length();
		int max = length/2*2;
		for(;max>=2;max-=2){
			for(int i=0;i<=length-max;i++){
				String sub = s.substring(i, i+max);
				if(isParenth(sub))	{
					System.out.println(i+":"+sub);
					return max;
					
				}
			}
		}
        return 0;
    }
	private boolean isParenth(String str)	{
		StringBuffer sb = new StringBuffer(str);
	
		if(sb.charAt(0)!='(' || sb.charAt(sb.length()-1) !=')')	{
			return false;
		}
		int dif=0;
		for(int i=0;i<sb.length();i++)	{
			if(sb.charAt(i) == '(')	{
				dif++;
			} else {
				dif--;
			}
		}
		if(dif != 0)	{
			return false;
		}
		
		boolean trimed;
		do	{
			trimed = false;
			for(int i=0;i<sb.length()-1;i++)	{
				if(sb.charAt(i) == '(' && sb.charAt(i+1) == ')')	{
					sb.delete(i, i+2);
					trimed = true;
				}
			}
		} while(trimed == true);
		return sb.length() == 0;
	}
	
	
	public static void main1(String[] args) {
		String str = "(()()((())))";
		Q32_LongestValidParentheses test = new Q32_LongestValidParentheses();
		System.out.println(test.isParenth(str));
	}
	
}

