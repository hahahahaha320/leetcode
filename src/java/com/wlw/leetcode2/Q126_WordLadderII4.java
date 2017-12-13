package com.wlw.leetcode2;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Q126_WordLadderII4 {
	/**
	 * 此题可以很快想到是树的最短距离问题，可以构造一个树，用最短距离算法来做，但是这样O(n平方)肯定是超时。
	 * 也可以想到从结果target出发，构造可以到达target的节点（1级），然后能到达1级的节点（2级），一直到beginWord为止。
	 * 然后找出那些路径。其实就是BFS构造树（不完全的树），然后用DFS来找出路径。
	 * 但是即使知道这个方法，也非常容易超时。
	 * 关键点：1.要找出所有能到达target的节点，可以先构造所有可达target的点的集合reachSet（每次一个字母的遍历），
	 * 		然后找出wordList和reachSet的交集。注意这里可以用set的contains来减少计算量。
	 * 	2.在生成可达的word时，使用 target.toCharArray，然后修改其中一个字符。
	 * @param args
	 */
	public static void main(String[] args) {
		Q126_WordLadderII4 test = new Q126_WordLadderII4();
		
		String beginWord = "charge";
		String endWord = "comedo";
		String str = ""+/**~{*/""
				+ "[]"
			+ "\r\n"/**}*/;
		
		List<String> wordList = ParamUtil.str2List(str);
		Date start = new Date();
		Object result = test.findLadders(beginWord,endWord,wordList);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
		
	}
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		if(!wordList.contains(endWord))	{
			return new ArrayList<List<String>>();
		}
		Set<String> wordSet = new HashSet<String>();
		for(String word : wordList)	{
			wordSet.add(word);
		}
		Map<String,Set<String>> roadMap = new HashMap<String,Set<String>>();
		Set<String> usedStr = new HashSet<String>();
		Set<String> targetList = new HashSet<String>();
		usedStr.add(endWord);
		targetList.add(endWord);
		boolean isFind = false;
		while(!targetList.isEmpty() && !isFind)	{
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
							putIntoMap(roadMap, word,target);
							usedTemp.add(word);
							newTargetList.add(word);
						}
						if(word.equals(beginWord))	{
							isFind = true;
							putIntoMap(roadMap,beginWord,target);
						}
	                }  
	            }
			}
			usedStr.addAll(usedTemp);
			targetList = newTargetList;
		}
		List<List<String>> result = new ArrayList<List<String>>();
		if(!isFind)	{
			return result;
		}
		List<String> subReuslt = new ArrayList<String>();
		subReuslt.add(beginWord);
		result.add(subReuslt);
		boolean isOver = false;
		while(!isOver)	{
			List<List<String>> tempResult = new ArrayList<List<String>>();
			for(List<String> subList : result)	{
				Set<String> target = roadMap.get(subList.get(subList.size()-1));
				List<String> copyList = new ArrayList<String>();
				if(target.size() > 1)	{
					copyList.addAll(subList);
				}
				int index = 0;
				for(String next : target)	{
					if(next.equals(endWord))	{
						isOver = true;
					}
					if(index==0)	{
						subList.add(next);
					} else {
						List<String> newList = new ArrayList<String>();
						newList.addAll(copyList);
						newList.add(next);
						tempResult.add(newList);
					}
					index++;
				}
			}
			result.addAll(tempResult);
		}
		return result;
    }
	private void putIntoMap(Map<String,Set<String>> roadMap,String key,String word)	{
		Set<String> targetList = roadMap.get(key);
		if(targetList == null)	{
			targetList = new HashSet<String>();
			roadMap.put(key,targetList);
		}
		targetList.add(word);
	}
}

