package com.wlw.leetcode;

import java.util.Date;

public class Q65_ValidNumber {

	public static void main(String[] args) {
		Q65_ValidNumber test = new Q65_ValidNumber();
		
		Date start = new Date();
		
		String str = "+.8";
		boolean result = test.isNumber(str);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	//java.util.regex.Pattern p = java.util.regex.Pattern.compile(".*[^e.\\d\\s-+].*");
	public boolean isNumber(String s) {
        try	{
        	//java.util.regex.Matcher m = p.matcher(s);
        	s = s.trim();
        	char last = s.charAt(s.length()-1);
        	if(last == 'd' || last == 'f' || last == 'l' ||
        		last == 'D' || last == 'F' || last == 'L')	{
        		return false;
        	}
        	Double.parseDouble(s);
        	return true;
        } catch(Exception e)	{
        	return false;
        }
    }
}

