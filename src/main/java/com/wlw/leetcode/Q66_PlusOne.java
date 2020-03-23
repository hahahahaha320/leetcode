package com.wlw.leetcode;

import java.util.Date;

public class Q66_PlusOne {

	public static void main(String[] args) {
		Q66_PlusOne test = new Q66_PlusOne();
		
		Date start = new Date();
		
		int[] result = test.plusOne(new int[]{0});
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
		for(int num : result)	{
			System.out.print(num+",");
		}
	}
	public int[] plusOne(int[] digits) {
        int i=digits.length-1;
		for(;i>=0;i--)	{
        	if(digits[i] == 9)	{
        		digits[i] = 0;
        	} else {
        		break;
        	}
        }
		if(i>=0)	{
			digits[i]++;
			return digits;
		} else {
			int[] result = new int[digits.length+1];
			result[0]=1;
			return result;
		}
    }
}

