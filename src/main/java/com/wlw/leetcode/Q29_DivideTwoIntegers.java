package com.wlw.leetcode;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q29_DivideTwoIntegers {

	public static void main(String[] args) {
		Q29_DivideTwoIntegers test = new Q29_DivideTwoIntegers();
		
		Date start = new Date();
		
		int result = test.divide(-2147483648,1);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	
	public int divide(int dividend, int divisor) {
		if(dividend == 0)	{
			return 0;
		}
		boolean isPos = true;
		if(dividend>0 && divisor<0 || dividend<0 && divisor>0)	{
			isPos = false;
		}
		long a = dividend;
		long b = divisor;
		a = Math.abs(a);
		b = Math.abs(b);
		
		Map<Long,Long> multiMap = new HashMap<Long,Long>();
		List<Long> multiList = new ArrayList<Long>();
		long multiValue = b;
		long multi = 1;
		while(a>=multiValue && multiValue>=0)	{
			multiList.add(multiValue);
			multiMap.put(multiValue,multi);
			multiValue  = multiValue+multiValue;
			multi = 2*multi;
		}
		
		long result = 0;
		for(int i=multiList.size()-1;i>=0;i--)	{
			long val = multiList.get(i);
			if(a>=val)	{
				result+=multiMap.get(val);
				a = a-val;
			}
		}
		if(!isPos)	{
			result = -result;
		}
		
		if(result>Integer.MAX_VALUE)	{
			result = Integer.MAX_VALUE;
		}
		if(result<Integer.MIN_VALUE)	{
			result = Integer.MIN_VALUE;
		}
		return (int)result;
    }
}

