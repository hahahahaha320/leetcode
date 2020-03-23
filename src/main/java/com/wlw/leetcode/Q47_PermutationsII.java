package com.wlw.leetcode;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q47_PermutationsII {

	public static void main(String[] args) {
		Q47_PermutationsII test = new Q47_PermutationsII();
		
		Date start = new Date();
		
		int[] nums = new int[]{2,1,1};
		List<List<Integer>> result = test.permuteUnique(nums);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	
	public List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		perm(0, num, res);
		return res;
	}

	public void swap(int arr[], int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	public void perm(int start, int[] num, List<List<Integer>> res) {
		if (start >= num.length) {
			List<Integer> tmp = new ArrayList<Integer>(num.length);
			for (int n : num)	{
				tmp.add(n);
			}
			res.add(tmp);
			return;
		}
		
		Set<Integer> usedSet = new HashSet<Integer>();
		for (int i = start; i < num.length; i++) {
			if(usedSet.contains(num[i]))	{
				continue;
			} 
			usedSet.add(num[i]);
			
			swap(num, start, i);
			perm(start + 1, num, res);
			swap(num, start, i);
		}
	}
}

