package com.wlw.leetcode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Q46_Permutations {

	public static void main(String[] args) {
		Q46_Permutations test = new Q46_Permutations();
		
		Date start = new Date();
		
		int[] nums = new int[]{1,2,3,7};
		List<List<Integer>> result = test.permute(nums);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	
	public List<List<Integer>> permute(int[] num) {
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

		for (int i = start; i < num.length; i++) {
			swap(num, start, i);
			perm(start + 1, num, res);
			swap(num, start, i);
		}

	}
}

