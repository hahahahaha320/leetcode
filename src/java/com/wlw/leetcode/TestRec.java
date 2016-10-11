package com.wlw.leetcode;

import java.util.ArrayList;
import java.util.List;

public class TestRec {
	
	private static void rec(List<Integer> list,int num,List<Integer> result){
		if(num==0)	{
			System.out.println(result);
			return;
		}
		for(int i=0;i<list.size();i++)	{
			if(result.contains(list.get(i)))	{
				continue;
			}
			result.add(list.get(i));
			rec(list, num-1, result);
			result.remove(list.get(i));
		}
	}
	
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);list.add(2);list.add(3);list.add(4);list.add(5);
		List<Integer> result = new ArrayList<Integer>();
		
		rec(list, 2, result);
	}
}
