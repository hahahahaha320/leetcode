package com.wlw.leetcode2;

import java.util.Date;
import java.util.Stack;

public class Q224_BasicCalculator {
	private static long totalCount = 0;
	public static void main(String[] args) {
		Q224_BasicCalculator test = new Q224_BasicCalculator();
		
		Date start = new Date();
		
//		String str = "((4+5+2)-3)+1)";
//		String str = " 2-1 + 2 ";
		String str = "1";
		Object result = test.calculate(str);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime())+",totalCount:"+totalCount);
		System.out.println(result);
	}
	
	public int calculate(String s) {
		s = s + " ";
        Stack<Integer> stack = new Stack<Integer>();
        boolean canCal = false;
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++)	{
        	if(arr[i] == '(')	{
        		canCal = false;
        	} else if(arr[i] == '+')	{
        		canCal = true;
        		stack.push(-1);
        	} else if(arr[i] == '-')	{
        		canCal = true;
        		stack.push(-2);
        	} else if(arr[i] == ')')	{
        		if(stack.size() >= 3)	{
	        		int num1 = stack.pop();
	        		int op = stack.pop();
	        		int num2 = stack.pop();
	        		if(op == -1)	{
	    				stack.push(num2+num1);
	    			} else {
	    				stack.push(num2-num1);
	    			}
        		}
        	} else if(arr[i] == ' ')	{
        		
        	} else {
        		int num1=0;
        		for(int j=i+1;j<arr.length;j++)	{
        			if(arr[j] < '0' || arr[j] > '9')	{
        				num1 = Integer.parseInt(s.substring(i,j));
        				i = j-1;
        				break;
        			}
        		}
        		if(canCal)	{
        			int op = stack.pop();
        			int num2 = stack.pop();
        			if(op == -1)	{
        				stack.push(num2+num1);
        			} else {
        				stack.push(num2-num1);
        			}
        		} else {
        			stack.push(num1);
        		}
        	}
        }
        return stack.pop();
	}
}

