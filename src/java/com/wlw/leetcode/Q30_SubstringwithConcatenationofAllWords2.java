package com.wlw.leetcode;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//参考滑动窗口算法文章：http://blog.csdn.net/linhuanmars/article/details/20342851?utm_source=tuicool&utm_medium=referral
//http://www.2cto.com/kf/201406/311648.html
public class Q30_SubstringwithConcatenationofAllWords2 {

	public static void main(String[] args) {
		Q30_SubstringwithConcatenationofAllWords2 test = new Q30_SubstringwithConcatenationofAllWords2();

		Date start = new Date();

		String str = "barfoofoobarthefoobarman";
		String[] words = new String[] {"bar","foo","the"};
		List<Integer> result = test.findSubstring(str, words);

		Date end = new Date();
		System.out.println("time:" + (end.getTime() - start.getTime()));
		System.out.println(result);
	}

	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<Integer>();
		if (s == null || s.length() == 0 || words == null || words.length == 0)	{
			return result;
		}
		Map<String,Integer> map = statCountToMap(words);
		int wordLen = words[0].length();
		int totalLen = s.length();
		for(int i=0;i<wordLen;i++)	{//为了不遗漏从s的每一个位置开始的子串，第一层循环为单词的长度
			Map<String,Integer> curMap = new HashMap<String,Integer>();
			int count=0;
			int left = i;
			for(int j=i;j<=totalLen-wordLen;j+=wordLen)	{
				String str = s.substring(j,j+wordLen);
				if(map.get(str) == null)	{
					curMap.clear();
					count=0;
					left = j+wordLen;
					continue;
				}
				
				updateCount(curMap, str);
				count++;
				if(curMap.get(str) > map.get(str))	{//如果此字符串个数超了，则前面的窗口往前移动，一直到次数刚好为止
					while(curMap.get(str) > map.get(str))	{
						String temp = s.substring(left,left+wordLen);
						curMap.put(temp, curMap.get(temp) - 1);
						count--;
						left += wordLen;
					}
				}
				if(count == words.length)	{//判断是否ok
					result.add(left);
					String temp = s.substring(left,left+wordLen);
					curMap.put(temp,curMap.get(temp)-1);  
					count--;
					left += wordLen;
				}
				
			}
		}
		return result;
	}
	private Map<String,Integer> statCountToMap(String[] words)	{
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(String word : words)	{
			updateCount(map, word);
		}
		return map;
	}
	private void updateCount(Map<String,Integer> map,String str)	{
		Integer count = map.get(str);
		if(count == null)	{
			map.put(str, 1);
		} else {
			map.put(str,count+1);
		}
	}
}
