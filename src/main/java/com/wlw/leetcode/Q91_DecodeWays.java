package com.wlw.leetcode;

import java.util.Date;

public class Q91_DecodeWays {

	public static void main(String[] args) {
		Q91_DecodeWays test = new Q91_DecodeWays();
		
		Date start = new Date();
//		String str = "9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253";
		String str = "123";
		Object result = test.numDecodings(str);

		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public int numDecodings(String s) {
		if(s.startsWith("0") || s == null || s.length() == 0)	{
	      	return 0;
	    }
		return numDecodingsRec(s);
	}
	public int numDecodingsRec(String s) {
        if(s.startsWith("0"))	{
        	return 0;
        }
        if(s.length() <= 1)	{
			return 1;
		}
        int total = numDecodings(s.substring(1));
        if(Integer.parseInt(s.substring(0, 2)) < 27)	{
        	total  += numDecodingsRec(s.substring(2));
        }
        return total;
    }
}

