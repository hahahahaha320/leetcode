package com.wlw.leetcode;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q22_GenerateParentheses2 {

	public static void main(String[] args) {
		Q22_GenerateParentheses2 test = new Q22_GenerateParentheses2();
		
		Date start = new Date();
		
		List<String> result = test.generateParenthesis(1);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
		System.out.println(result.size());
	}
	public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        Map<String,Integer> oldMap = new HashMap<String,Integer>();
        oldMap.put("(", 1);
        for(int i=2;i<=2*n;i++)	{
        	Map<String,Integer> newMap = new HashMap<String,Integer>();
        	for(String key : oldMap.keySet())	{
        		int num = oldMap.get(key);
        		if(num == 0)	{
        			newMap.put(key+"(",1);
        		} else if(2*n-i+1 == num)	{
        			newMap.put(key+")",num-1);
        		} else {
        			newMap.put(key+"(",num+1);
        			newMap.put(key+")",num-1);
        		}
        	}
        	oldMap = newMap;
        }
        result.addAll(oldMap.keySet());
        return result;
	}
}

