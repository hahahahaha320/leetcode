package com.wlw.leetcode;

import java.util.Date;
import java.util.Stack;

public class Q71_SimplifyPath {

	public static void main(String[] args) {
		Q71_SimplifyPath test = new Q71_SimplifyPath();
		
		Date start = new Date();
		
		String str = "/..";
		Object result = test.simplifyPath(str);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public String simplifyPath(String path) {
        String[] sa = path.split("/");
        Stack<String> stack = new Stack<String>();
        for(String a : sa)	{
        	if("".equals(a) || ".".equals(a))	{
        	} else if("..".equals(a))	{
        		if(stack.size() > 0)	{
        			stack.pop();
        		}
        	} else {
        		stack.push(a);
        	}
        }
        if(stack.size() == 0)	{
        	return "/";
        }
        String result = "";
        for(String str : stack)	{
        	result = result+"/"+str;
        }
        return result;
    }
}

