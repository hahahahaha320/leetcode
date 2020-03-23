package com.wlw.leetcode;

import java.util.Date;

public class Q12_IntegerToRoman {

	public static void main(String[] args) {
		Q12_IntegerToRoman test = new Q12_IntegerToRoman();
		
		Date start = new Date();
		
		String result = test.intToRoman(3949);
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	
	public String intToRoman(int num) {
		String[][] roman = {  
	            {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},  
	            {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},  
	            {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},  
	            {"", "M", "MM", "MMM"}  
	    }; 
		int digit = 0;
		String result = "";
		while(num > 0)	{
			int remain = num%10;
			
			result = roman[digit][remain]+result;
			num = num /10;
			digit++;
		}
        return result;
    }
	
}

