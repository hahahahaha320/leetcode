package com.wlw.leetcode;

import java.util.Date;

public class Q13_RomantoInteger {

	public static void main(String[] args) {
		Q13_RomantoInteger test = new Q13_RomantoInteger();
		Date start = new Date();
		int result = test.romanToInt("MCMXCVI");
		//1996  M       C   M       X C     V  I
		//		1000   100 1000    10 100   5  1
 		
		Date end = new Date();
		
		System.out.println("Used time:"+ (end.getTime()-start.getTime()));
		
		System.out.println(result);
		
	}
	
	public int romanToInt(String s) {
		int result = toNumber(s.charAt(0));
		for(int i=1;i<s.length();i++)	{
			result = result + toNumber(s.charAt(i));
			if(toNumber(s.charAt(i)) > toNumber(s.charAt(i-1)))	{
				result = result - 2*toNumber(s.charAt(i-1));
			}
		}
		return result;
    }
	int toNumber(char ch) {  
        switch (ch) {  
            case 'I': return 1;  
            case 'V': return 5;  
            case 'X': return 10;  
            case 'L': return 50;  
            case 'C': return 100;  
            case 'D': return 500;  
            case 'M': return 1000;  
        }  
        return 0;  
    }  
}
