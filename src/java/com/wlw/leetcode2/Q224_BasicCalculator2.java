package com.wlw.leetcode2;

import java.util.Date;

public class Q224_BasicCalculator2 {
	private static long totalCount = 0;
	public static void main(String[] args) {
		Q224_BasicCalculator2 test = new Q224_BasicCalculator2();
		
		Date start = new Date();
		
//		String str = "((4+5+2)-3)+1)";
//		String str = " 2-1 + 2 ";
		String str = "1";
		Object result = test.calculate(str);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime())+",totalCount:"+totalCount);
		System.out.println(result);
	}
	
	 int index = 0;
    public int calculate(String s) {
        return helper(s);
    }
    
    private int helper(String s) {
        int sum = 0;
        int curNum = 0;
        int sign = 1;
        for (; index < s.length(); index++) {
            char curChar = s.charAt(index);
            // this question treat space as '+'
            if (curChar == ' ' || curChar == '+') {
                sum += sign * curNum;
                curNum = 0;
                sign = 1;
            } else if (curChar <= '9' && curChar >= '0') {
                curNum = curNum * 10 + curChar - '0';
            } else if (curChar == '-') {
                sum += sign * curNum;
                curNum = 0;
                sign = -1;
            } else if (curChar == '(') {
                index++;
                curNum = helper(s);
                sum += sign * curNum;
                sign = 1;
                curNum = 0;
            } else if (curChar == ')') {
                break;
            }
        }
        sum += sign * curNum;
        return sum;
    }
}

