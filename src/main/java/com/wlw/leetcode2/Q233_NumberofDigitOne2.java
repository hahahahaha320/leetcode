package com.wlw.leetcode2;

import java.util.Date;

public class Q233_NumberofDigitOne2 {
	private static long totalCount = 0;
	public static void main(String[] args) {
		Q233_NumberofDigitOne2 test = new Q233_NumberofDigitOne2();
		
		Date start = new Date();
		
//		answer:1737167499,
//		result:551071949
		//	   900000000
		//	   1410065408
		int m = 1410065408;
		int result = test.countDigitOne(m);
		System.out.println("result:"+result);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime())+",totalCount:"+totalCount);
	}
	public int countDigitOne(int n) {
    	int count = 0;
		for (long k = 1; k <= n; k *= 10) {
			long r = n / k;
			long m = n % k;
			count += (r + 8) / 10 * k + (r % 10 == 1 ? m + 1 : 0); 
		}
		return count;
	}
}

