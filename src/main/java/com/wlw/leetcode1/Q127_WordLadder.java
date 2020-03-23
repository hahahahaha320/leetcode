package com.wlw.leetcode1;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.wlw.leetcode.util.ParamUtil;

public class Q127_WordLadder {

	public static void main(String[] args) {
		Q127_WordLadder test = new Q127_WordLadder();
		
		String beginWord = "hit";
		String endWord = "cog";
		String str = ""+/**~{*/""
			+ "[\"hot\",\"dot\",\"dog\",\"lot\",\"log\",\"cog\"]"
		+ "\r\n"/**}*/;
		
		List<String> wordList = ParamUtil.str2List(str);
		Date start = new Date();
		Object result = test.ladderLength(beginWord,endWord,wordList);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
		
	}
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if(!wordList.contains(endWord))	{
			return 0;
		}
		Set<String> wordSet = new HashSet<String>();
		for(String word : wordList)	{
			wordSet.add(word);
		}
		Set<String> usedStr = new HashSet<String>();
		Set<String> targetList = new HashSet<String>();
		usedStr.add(endWord);
		targetList.add(endWord);
		boolean isFind = false;
		int level = 0;
		while(!targetList.isEmpty() && !isFind)	{
			level++;
			Set<String> newTargetList = new HashSet<String>();
			Set<String> usedTemp = new HashSet<String>();
			for(String target : targetList)	{
				for(int i=0;i<target.length();i++) {  
	                char[] strCharArr = target.toCharArray();  
	                for(char ch='a';ch<='z';ch++) {  
	                    if(strCharArr[i]==ch) {  
	                        continue;  
	                    }  
	                    strCharArr[i] = ch;  
	                    String word = new String(strCharArr);  
	                    if(!usedStr.contains(word) && wordSet.contains(word))	{
							usedTemp.add(word);
							newTargetList.add(word);
						}
						if(word.equals(beginWord))	{
							return level+1; 
						}
	                }  
	            }
			}
			usedStr.addAll(usedTemp);
			targetList = newTargetList;
		}
		return 0;
    }
}

