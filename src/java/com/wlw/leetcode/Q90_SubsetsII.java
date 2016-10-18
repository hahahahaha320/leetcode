package com.wlw.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Q90_SubsetsII {

	public static void main(String[] args) {
		Q90_SubsetsII test = new Q90_SubsetsII();
		
		Date start = new Date();
		
		Object result = test.subsetsWithDup(new int[]{1,2,2});

		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(nums);
		for(int i=0;i<=nums.length;i++)	{
			combine(nums,result, list,0,nums.length-1,i);
		}
		return result;
    }
	public void combine(int[] nums,List<List<Integer>> result,List<Integer> list,int m,int n,int k)	{
		if(k == 0)	{
			result.add(new ArrayList<Integer>(list));
		}
		for(int i=m;i<=n;i++)	{
			list.add(nums[i]);
			combine(nums,result,list,i+1,n,k-1);
			list.remove(list.size()-1);
			//跳过重复
			while(i<(nums.length-1)&&nums[i]==nums[i+1]) {  
                i++;  
            }  
		}
	}
}

