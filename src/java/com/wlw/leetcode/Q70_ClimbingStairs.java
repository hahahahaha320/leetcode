package com.wlw.leetcode;

import java.util.Date;

public class Q70_ClimbingStairs {

	public static void main(String[] args) {
		Q70_ClimbingStairs test = new Q70_ClimbingStairs();
		
		Date start = new Date();
		
		Object result = test.climbStairs(5);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public int climbStairs(int n) {
        if(n<=1)	{
        	return 1;
        }
        int pre1=1,pre2=1,result=0;
        for(int i=2;i<=n;i++)	{
        	result = pre1+pre2;
        	pre2=pre1;
        	pre1=result;
        }
        return result;
    }
}

