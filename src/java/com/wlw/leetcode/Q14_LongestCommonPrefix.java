package com.wlw.leetcode;

import java.util.Date;

public class Q14_LongestCommonPrefix {

	public static void main(String[] args) {
		Q14_LongestCommonPrefix test = new Q14_LongestCommonPrefix();
		
		Date start = new Date();
		
		String[] str = new String[]{"ab","abc",""};
		String result = test.longestCommonPrefix(str);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)	{
        	return "";
        }
        if(strs.length==1)	{
        	return strs[0];
        }
        String first = strs[0];
        int i=0;
        for(;i<first.length();i++)	{
        	char c = first.charAt(i);
        	boolean ok = true;
        	for(int j=1;j<strs.length;j++)	{
        		if(strs[j].length()<i+1 || strs[j].charAt(i) != c)	{
        			ok = false;
        			break;
        		}
        	}
        	if(!ok)	{
        		break;
        	}
        }
        return strs[0].substring(0,i);
    }
}

