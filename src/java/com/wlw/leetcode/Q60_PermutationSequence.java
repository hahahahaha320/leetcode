package com.wlw.leetcode;

import java.util.Date;

public class Q60_PermutationSequence {

	public static void main(String[] args) {
		Q60_PermutationSequence test = new Q60_PermutationSequence();
		
		Date start = new Date();
		
		String result = test.getPermutation(5,6);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public String getPermutation(int n, int k) {
        return "";
    }
}

