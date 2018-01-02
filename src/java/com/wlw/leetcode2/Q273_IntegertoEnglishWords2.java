package com.wlw.leetcode2;

import java.util.Date;

public class Q273_IntegertoEnglishWords2 {
	private static long totalCount = 0;
	public static void main(String[] args) {
		Q273_IntegertoEnglishWords2 test = new Q273_IntegertoEnglishWords2();
		
		Date start = new Date();
		/*
		103 -> "One Hundred Three"
		123 -> "One Hundred Twenty Three"
		12345 -> "Twelve Thousand Three Hundred Forty Five"
		1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
		*/
		int[] tests = new int[]{0,1,10,11,20,24,100,104,115,120,189,1001,1100,1010,1119,1020,1298,1300};
//		int[] tests = new int[]{1234567891};
		for(int num:tests)	{
			System.out.println(num + "  : " + test.numberToWords(num));
		}
		Object result = test.numberToWords(1);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime())+",totalCount:"+totalCount);
		System.out.println(result);
	}
	static String[] TWENTIES = new String[] {"", " One", " Two", " Three", " Four", " Five", " Six",
            " Seven", " Eight", " Nine", " Ten", " Eleven", " Twelve",
            " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen",
            " Eighteen", " Nineteen"};
	static String[] TENS = new String[] {"", " Ten", " Twenty", " Thirty", " Forty", " Fifty", " Sixty",
	    " Seventy", " Eighty", " Ninety", " Hundred"};
	static String[] THOUSANDS = new String[] {"", " Thousand", " Million", " Billion"};
	
	public String numberToWords(int num) {
		if (num == 0) {
			return "Zero";
		}
		int BASE = 1000;
		String res = "";
		int i = 0;
		while (num != 0) {
			int cur = num % BASE;
			res = helper(cur) + (cur == 0 ? "" : THOUSANDS[i]) + res;
			num = num / BASE;
			i++;
		}
		return res.substring(1, res.length());
	}

	public String helper(int num) {
		if (num < 20) {
			return TWENTIES[num];
		}
		if (num < 100) {
			return TENS[num / 10] + TWENTIES[num % 10];
		}
		return TWENTIES[num / 100] + " Hundred" + helper(num % 100);
	}
}

