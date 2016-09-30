package com.wlw.leetcode;

import java.util.Date;

public class Q67_AddBinary {

	public static void main(String[] args) {
		Q67_AddBinary test = new Q67_AddBinary();
		
		Date start = new Date();
		
		String result = test.addBinary("10","110");
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public String addBinary(String a, String b) {
		int lena = a.length();
		int lenb = b.length();
		int maxLength = Math.max(lena,lenb);
		int carry = 0;
		String result = "";
		for(int i=0;i<maxLength;i++)	{
			int posa = lena-1-i;
			int posb = lenb-1-i;
			int sum = (posa>=0?a.charAt(posa):'0')+(posb>=0?b.charAt(posb):'0')+carry-96;
			result = (sum%2)+result;
			carry = sum/2;
		}
		if(carry == 1)	{
			result = "1"+result;
		}
        return result;
    }
}

