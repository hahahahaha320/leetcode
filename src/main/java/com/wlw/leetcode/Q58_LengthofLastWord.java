package com.wlw.leetcode;

import java.util.Date;

public class Q58_LengthofLastWord {

	public static void main(String[] args) {
		Q58_LengthofLastWord test = new Q58_LengthofLastWord();
		
		Date start = new Date();
		
		String str = "Hello World ";
		int result = test.lengthOfLastWord(str);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public int lengthOfLastWord(String s) {
		s = s.trim();
        int pos = s.lastIndexOf(' ');
        if(s.lastIndexOf(' ') == -1)	{
        	return s.length();
        } 
        return s.length() - pos-1;
       
    }
}

