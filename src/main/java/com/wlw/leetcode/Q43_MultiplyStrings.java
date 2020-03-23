package com.wlw.leetcode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Q43_MultiplyStrings {

	public static void main(String[] args) {
		Q43_MultiplyStrings test = new Q43_MultiplyStrings();
		
		Date start = new Date();
		
		String str1 = "140";
		String str2 = "721";
		String result = test.multiply(str1,str2);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public String multiply(String num1, String num2) {
		if("0".equals(num1)||"0".equals(num2))	{
			return "0";
		}
		boolean neg = false;
		if(num1.charAt(0) == '-')	{
			neg = true;
			num1 = num1.substring(1);
		}
		if(num2.charAt(0) == '-')	{
			neg = !neg;
			num2 = num2.substring(1);
		}
		List<String> mulList = new ArrayList<String>();
		int digital = 0;
		for(int i=num2.length()-1;i>=0;i--)	{
			mulList.add(singalMul(num1, ((int)num2.charAt(i)-48),digital));
			digital++;
		}
		int maxLength = 0;
		for(String str : mulList)	{
			maxLength = Math.max(maxLength,str.length());
		}
		String result = "";
		int carry = 0;
        for(int i=0;i<maxLength;i++)	{
        	int sum = 0;
        	for(String str : mulList)	{
        		if(str.length()>i)	{
        			sum += ((int)str.charAt(i)-48);
        		}
        	}
        	sum += carry;
        	result = sum%10+result;
			carry = sum/10;
        }
        if(carry>0)	{
			result = carry + result;
		}
        if(neg)	{
        	return "-"+result;
        }
		return result;
    }
	private String singalMul(String num1,int singal,int digital)	{
		String result = "";
		int carry = 0;
		for(int i=num1.length()-1;i>=0;i--)	{
			int mul = ((int)num1.charAt(i)-48)*singal + carry;
			result = mul%10+result;
			carry = mul/10;
		}
		if(carry>0)	{
			result = carry + result;
		}
		for(int i=0;i<digital;i++)	{
			result = result + "0";
		}
		return new StringBuffer(result).reverse().toString();
	}
}

