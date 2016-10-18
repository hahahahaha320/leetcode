package com.wlw.leetcode;

import java.util.Date;

public class Q91_DecodeWays {

	public static void main(String[] args) {
		Q91_DecodeWays test = new Q91_DecodeWays();
		
		Date start = new Date();
		
		Object result = test.numDecodings("12");

		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public int numDecodings(String s) {
        return 0;
    }
}

