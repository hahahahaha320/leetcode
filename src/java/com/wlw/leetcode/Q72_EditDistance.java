package com.wlw.leetcode;

import java.util.Date;

public class Q72_EditDistance {

	public static void main(String[] args) {
		Q72_EditDistance test = new Q72_EditDistance();
		
		Date start = new Date();
		Object result = test.minDistance("dinitrophenylhydrazine","acetylphenylhydrazine");
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
		
	}
	public int minDistance(String word1, String word2) {
		if(word1.length()==0)	{
			return word2.length();
		}
		if(word2.length()==0)	{
			return word1.length();
		}
		int len1 = minDistance(word1.substring(1),word2.substring(1));
		if(word1.charAt(0) != word2.charAt(0))	{
			len1++;
		}
		int len2 = minDistance(word1.substring(1),word2.substring(0))+1;
		int len3 = minDistance(word1.substring(0),word2.substring(1))+1;
		return Math.min(len1,Math.min(len2,len3));
    }
	
}

