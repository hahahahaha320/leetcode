package com.wlw.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q39_CombinationSum {

	public static void main(String[] args) {
		Q39_CombinationSum test = new Q39_CombinationSum();
		
		Date start = new Date();
//		int[] candidates = new int[]{92,71,89,74,102,91,70,119,86,116,114,106,80,81,115,99,117,93,76,77,111,110,75,104,95,112,94,73};
//		int target = 310;
		int[] candidates = new int[]{2,3,4};
		int target = 7;
		List<List<Integer>> result = test.combinationSum(candidates,target);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> list = recurrence(candidates,target);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Set<String> set = new HashSet<String>();
		for(List<Integer> subList : list)	{
			Collections.sort(subList);
			String str = subList.toString();
			if(!set.contains(str))	{
				set.add(str);
				result.add(subList);
			}
		}
		return result;
    }
	private List<List<Integer>> recurrence(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for(int num : candidates)	{
			if(target == num)	{
				List<Integer> list = new ArrayList<Integer>();
				list.add(num);
				result.add(list);
			} else if(target > 0)	{
				List<List<Integer>> list = recurrence(candidates, target-num);
				if(list!= null && list.size() > 0)	{
					for(List<Integer> subList : list)	{
						subList.add(num);
						result.add(subList);
					}
				}
			}
		}
        return result;
    }
}

