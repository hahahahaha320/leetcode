package com.wlw.leetcode;

import java.util.Date;

public class Q72_EditDistance2 {

	public static void main(String[] args) {
		Q72_EditDistance2 test = new Q72_EditDistance2();
		
		Date start = new Date();
		Object result = test.minDistance("dinitrophenylhydrazine","acetylphenylhydrazine");
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
		
	}
	public int minDistance(String word1, String word2) {
		return minDistanceRec(word1, 0, word2, 0);
    }
	public int minDistanceRec(String word1,int from1, String word2,int from2) {
		if(word1.length()-from1==0)	{
			return word2.length()-from2;
		}
		if(word2.length()-from2==0)	{
			return word1.length()-from1;
		}
		int len1 = minDistanceRec(word1,from1+1,word2,from2+1);
		if(word1.charAt(from1) != word2.charAt(from2))	{
			len1++;
		}
		int len2 = minDistanceRec(word1,from1+1,word2,from2)+1;
		int len3 = minDistanceRec(word1,from1,word2,from2+1)+1;
		return Math.min(len1,Math.min(len2,len3));
    }
	
}

