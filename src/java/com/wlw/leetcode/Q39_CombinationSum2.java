package com.wlw.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Q39_CombinationSum2 {

	public static void main(String[] args) {
		Q39_CombinationSum2 test = new Q39_CombinationSum2();
		
		Date start = new Date();
//		int[] candidates = new int[]{92,71,89,74,102,91,70,119,86,116,114,106,80,81,115,99,117,93,76,77,111,110,75,104,95,112,94,73};
//		int target = 310;
		int[] candidates = new int[]{8,7,4,3};
		int target = 11;
		List<List<Integer>> result = test.combinationSum(candidates,target);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		recurrence(candidates, target, new ArrayList<Integer>(),0, result);
	    return result;
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
			recurrence(candidates, target-candidates[i], curList,i, result);
			curList.remove(curList.size()-1);
		}
	}
}

