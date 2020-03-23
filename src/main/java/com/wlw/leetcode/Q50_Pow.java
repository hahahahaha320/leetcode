package com.wlw.leetcode;

import java.util.Date;

public class Q50_Pow {

	public static void main(String[] args) {
		Q50_Pow test = new Q50_Pow();
		
		Date start = new Date();
		double x = 2;
		int n = -2147483648;
		double result = test.myPow(x,n);
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	
	public double myPow(double x, int n) {
		if (n == 0 || x == 1) return 1;
		if (x == 0) return 0;
		
		boolean rec = false;
		long a = n;
		if (n < 0) {
			rec = true;
			a = Math.abs((long)-n);
		}
		double t = myPow(x, (int)(a/2));
		double result;
		if (a%2 == 1)	{
			result = x*t*t;
		} else {
			result = t*t;
		}
		if(rec)	{
			return 1/result;
		}
		return result;
    }

}

