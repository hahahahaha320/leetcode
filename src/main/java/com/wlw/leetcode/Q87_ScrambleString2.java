package com.wlw.leetcode;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Q87_ScrambleString2 {

	public static void main(String[] args) {
		Q87_ScrambleString2 test = new Q87_ScrambleString2();
		
		Date start = new Date();
		
//		Object result = test.isScramble("great","reatg");
		Object result = test.isScramble("abcdefghijklmnopq","efghijklmnopqcadb");
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public boolean isScramble(String s1, String s2) {
		return isScrambleRec(s1, s2, new HashMap<String,Boolean>());
	}
	public boolean isScrambleRec(String s1, String s2,Map<String,Boolean> cache) {
		int len = s1.length();
		if(len != s2.length())	{
			return false;
		}
		if(s1.equals(s2))	{
			return true;
		}
		if(!isSameCharset(s1, s2))	{
			return false;
		}
		String key = s1+"_"+s2;
		Boolean suc = cache.get(key);
		if(suc != null)	{
			return suc;
		}
		boolean result = false;
        for(int i=1;i<len;i++)	{
        	
        	String a1 = s1.substring(0,i);
        	String a2 = s1.substring(i,len);
        	if(isScrambleRec(a1,s2.substring(0,i),cache) && isScrambleRec(a2,s2.substring(i,len),cache)
        		|| isScrambleRec(a1,s2.substring(len-i,len),cache) && isScrambleRec(a2,s2.substring(0,len-i),cache)
        			)	{
        		result = true;
        		break;
        	}
        }
        cache.put(key, result);
        return result;
    }
	private boolean isSameCharset(String s1, String s2){
		byte[] arr1 = s1.getBytes();
		Arrays.sort(arr1);
		s1 = new String(arr1);
		byte[] arr2 = s2.getBytes();
		Arrays.sort(arr2);
		s2 = new String(arr2);
		return s1.equals(s2);
	}
}

