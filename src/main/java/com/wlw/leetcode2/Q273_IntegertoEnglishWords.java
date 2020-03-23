package com.wlw.leetcode2;

import java.util.Date;

public class Q273_IntegertoEnglishWords {
	private static long totalCount = 0;
	public static void main(String[] args) {
		Q273_IntegertoEnglishWords test = new Q273_IntegertoEnglishWords();
		
		Date start = new Date();
		/*
		103 -> "One Hundred Three"
		123 -> "One Hundred Twenty Three"
		12345 -> "Twelve Thousand Three Hundred Forty Five"
		1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
		*/
//		int[] tests = new int[]{0,1,10,11,20,24,100,104,115,120,189,1001,1100,1010,1119,1020,1298,1300};
		int[] tests = new int[]{1234567891};
		for(int num:tests)	{
			System.out.println(num + "  : " + test.numberToWords(num));
		}
		Object result = test.hundred2Str(1);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime())+",totalCount:"+totalCount);
		System.out.println(result);
	}
	public String numberToWords(int num) {
		if(num == 0)	{
			return "Zero";
		}
		String result = "";
		int div = num/1000000000;
		int remainder = num%1000000000;
		if(div > 0)	{
			result = hundred2Str(div) + " Billion ";
		}
		div = remainder/1000000;
		remainder = remainder%1000000;
		if(div > 0)	{
			result = result + hundred2Str(div) + " Million ";
		}
		div = remainder/1000;
		remainder = remainder%1000;
		if(div > 0)	{
			result = result + hundred2Str(div) + " Thousand ";
		}
		result = result + hundred2Str(remainder);
		return result.trim();
    }
	String[] digitStrArr = new String[]{"","One","Two","Three","Four","Five",
			"Six","Seven","Eight","Nine","Ten",
			"Eleven","Twelve","Thirteen","Fourteen","Fifteen",
			"Sixteen","Seventeen","Eighteen","Nineteen"};
	String[] tyStrArr = new String[]{"","","Twenty","Thirty","Forty","Fifty",
			"Sixty","Seventy","Eighty","Ninety"};
	private String hundred2Str(int num)	{
		int div = num/100;
		int remainder = num%100;
		String result = "";
		if(div > 0)	{
			result = digitStrArr[div] + " Hundred ";
		}
		if(remainder > 0 && remainder < 20)	{
			result = result + digitStrArr[remainder] + " ";
		} else if(remainder >= 20)	{
			div = remainder/10;
			remainder = remainder%10;
			if(div > 0)	{
				result = result + tyStrArr[div] + " ";
			}
			if(remainder > 0)	{
				result = result + digitStrArr[remainder] + " ";
			}
		}
		return result.trim();
	}
}

