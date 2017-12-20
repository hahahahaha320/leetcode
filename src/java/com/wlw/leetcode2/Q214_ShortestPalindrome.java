package com.wlw.leetcode2;

import java.util.Date;

public class Q214_ShortestPalindrome {
	private static long totalCount = 0;
	public static void main(String[] args) {
		Q214_ShortestPalindrome test = new Q214_ShortestPalindrome();
		
		Date start = new Date();
		
		String str = "aa";
		Object result = test.shortestPalindrome(str);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime())+",totalCount:"+totalCount);
		System.out.println(result);
	}
	public String shortestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int maxPos=arr.length-1;
        for(;maxPos>0;maxPos--)	{
        	boolean is = true;
        	for(int j=0;j<=(maxPos-1)/2;j++)	{
    			if(arr[j] != arr[maxPos-j])	{
    				is = false;
    				break;
    			}
    		}
        	if(is)	{
        		break;
        	}
        }
        char[] toAdd = new char[s.length()-maxPos-1];
        for(int i=s.length()-1;i>=maxPos+1;i--)	{
        	toAdd[s.length()-i-1] = arr[i];
        }
        return new String(toAdd) + s;
	}
}

