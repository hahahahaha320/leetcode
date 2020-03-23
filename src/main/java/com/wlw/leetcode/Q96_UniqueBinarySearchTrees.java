package com.wlw.leetcode;

import java.util.Date;

public class Q96_UniqueBinarySearchTrees {

	public static void main(String[] args) {
		Q96_UniqueBinarySearchTrees test = new Q96_UniqueBinarySearchTrees();
		
		Date start = new Date();
		
		Object result = test.numTrees(18);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public int numTrees(int n) {
		if(n==0)	{
			return 1;
		}
		int[] cache = new int[n];
		return numTrees(1, n,cache);
    }
    private int numTrees(int left, int right,int[] cache){
    	if(right-left < 1)	{
    		return 1;
    	}
    	if(cache[right-left] != 0)	{
    		return cache[right-left];
    	}
    	int total = 0;
        for (int i = left; i <= right; i++){
        	int lefts = numTrees(left, i-1,cache);
        	int rights = numTrees(i+1, right,cache);
        	total += lefts*rights;
        }
        cache[right-left] = total;
        return total;
    }
}

