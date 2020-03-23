package com.wlw.leetcode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Q77_Combinations {

	public static void main(String[] args) {
		Q77_Combinations test = new Q77_Combinations();
		
		Date start = new Date();
		
		Object result = test.combine(5,3);

		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		combine(result, list, 1, n, k);
		return result;
    }
	
	public void combine(List<List<Integer>> result,List<Integer> list,int m,int n,int k)	{
		if(k == 0)	{
			result.add(new ArrayList<Integer>(list));
		}
		for(int i=m;i<=n;i++)	{
			list.add(i);
			combine(result,list,i+1,n,k-1);
			list.remove(list.size()-1);
		}
	}
}

