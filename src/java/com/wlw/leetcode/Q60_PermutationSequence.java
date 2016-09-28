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
		int[] num = new int[n];
		int permCount = 1;
		for (int i = 0; i < n; i++) {
			num[i] = i + 1;
			permCount *= (i + 1);
		}
		k--;
		StringBuilder target = new StringBuilder();
		for (int i = 0; i < n; i++) {
			permCount = permCount / (n - i);
			int choosed = k / permCount;
			target.append(num[choosed]);
			for (int j = choosed; j < n - i - 1; j++) {
				num[j] = num[j + 1];
			}
			k = k % permCount;
		}
		return target.toString();
	}
}

