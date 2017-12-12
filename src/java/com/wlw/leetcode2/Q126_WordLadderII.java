package com.wlw.leetcode2;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Q126_WordLadderII {

	public static void main(String[] args) {
		Q126_WordLadderII test = new Q126_WordLadderII();
		
		String beginWord = "hit";
		String endWord = "cog";
		String str = ""+/**~{*/""
				+ "[\"hot\",\"dot\",\"dog\",\"lot\",\"log\",\"cog\"]"
			+ "\r\n"/**}*/;
		List<String> wordList = ParamUtil.str2List(str);
		
		Date start = new Date();
		Object result = test.findLadders(beginWord,endWord,wordList);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		try	{
			wordList.remove(endWord);
			Map<String,List<String>> roadMap = new HashMap<String,List<String>>();
			Set<String> usedStr = new HashSet<String>();
			BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
			usedStr.add(endWord);
			queue.put(endWord);
			while(!queue.isEmpty())	{
				String str = queue.take();
				
			}
			
		} catch(Exception e)	{
			e.printStackTrace();
		}
		return null;
    }
	private boolean isReach(String from,String to)	{
		int diffNum = 0;
		for(int i=0;i<from.length();i++)	{
			if(from.charAt(i) != to.charAt(i))	{
				diffNum++;
				if(diffNum > 1)	{
					return false;
				}
			}
		}
		return true;
	}
	
}

