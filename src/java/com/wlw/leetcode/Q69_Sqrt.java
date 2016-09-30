package com.wlw.leetcode;

import java.util.Date;

public class Q69_Sqrt {

	public static void main(String[] args) {
		Q69_Sqrt test = new Q69_Sqrt();
		
		Date start = new Date();
		int result = test.mySqrt(16);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	
	public int mySqrt(int x) {
		if (x ==0) return 0;  
        double pre;  
        double cur = 1;  
        do  {  
            pre = cur;  
            cur = x / (2 * pre) + pre / 2.0;  
        } while (Math.abs(cur - pre) > 0.00001);  
        return (int)cur; 
    }
}

