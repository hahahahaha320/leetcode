package com.wlw.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q40_CombinationSumII {

	public static void main(String[] args) {
		Q40_CombinationSumII test = new Q40_CombinationSumII();
		
		Date start = new Date();
		int[] candidates = new int[]{92,71,89,74,102,91,70,119,86,116,114,106,80,81,115,99,117,93,76,77,111,110,75,104,95,112,94,73};
		int target = 310;
		List<List<Integer>> result = test.combinationSum2(candidates,target);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		recurrence(candidates, target, new ArrayList<Integer>(),0, result);
		List<List<Integer>> result2 = new ArrayList<List<Integer>>();
		Set<String> set = new HashSet<String>();
		for(List<Integer> subList : result)	{
			Collections.sort(subList);
			String str = subList.toString();
			if(!set.contains(str))	{
				set.add(str);
				result2.add(subList);
			}
		}
	    return result2;
	}
	private void recurrence(int[] candidates,int target,List<Integer> curList,int n,List<List<Integer>> result)	{
		if(target == 0)	{
			result.add(new ArrayList<Integer>(curList));
		}
		for(int i=n;i<candidates.length;i++)	{
			if(target < candidates[i]) {
				return;
			}
			curList.add(candidates[i]);
			recurrence(candidates, target-candidates[i], curList,i+1, result);
			curList.remove(curList.size()-1);
		}
	}
}

