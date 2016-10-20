package com.wlw.leetcode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Q93_RestoreIPAddresses {

	public static void main(String[] args) {
		Q93_RestoreIPAddresses test = new Q93_RestoreIPAddresses();
		
		Date start = new Date();
		
		String str = "1234";
		Object result = test.restoreIpAddresses(str);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
		
	}
	public List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<String>();
		List<String> list = new ArrayList<String>();
        restoreIpAddressesRec(result, list, s, 4);;
        return result;
	}
	
	public void restoreIpAddressesRec(List<String> result,List<String> list,String s,int n) {
        if(n == 1)	{
        	if(isIp(s))	{
        		String ip = "";
        		for(String num : list)	{
        			ip = ip+num+".";
        		}
        		result.add(ip+s);
        	}
        	return;
        }
        for(int i=1;i<=3 && i<s.length();i++)	{
        	if(isIp(s.substring(0,i)))	{
        		list.add(s.substring(0,i));
        		restoreIpAddressesRec(result, list, s.substring(i), n-1);
        		list.remove(list.size()-1);
        	}
        }
    }
	private boolean isIp(String s)	{
		if(s == null || s.length() == 0 || s.length() > 3)	{
			return false;
		}
		if(s.length() == 1)	{
			return true;
		}
		if(s.charAt(0) == '0')	{
			return false;
		}
		if(s.length() == 3 && 
			(s.charAt(0) > '2' ||
				s.charAt(0) == '2' && 
			(s.charAt(1) > '5' || s.charAt(1) == '5' && s.charAt(2) > '5')))	{
			return false;
		}
		return true;
	}
}

