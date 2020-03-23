package com.wlw.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q49_GroupAnagrams {

	public static void main(String[] args) {
		Q49_GroupAnagrams test = new Q49_GroupAnagrams();
		
		Date start = new Date();
		
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> result = test.groupAnagrams(strs);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String,List<String>> map = new HashMap<String,List<String>>();
		List<List<String>> result = new ArrayList<List<String>>();
		for(String str : strs)	{
			char[] charArray = str.toCharArray();
			Arrays.sort(charArray);
			String key = new String(charArray);
			
			List<String> list = map.get(key);
			if(list == null)	{
				list = new ArrayList<String>();
				map.put(key, list);
				result.add(list);
			} 
			list.add(str);
		}
        return result;
    }

}

