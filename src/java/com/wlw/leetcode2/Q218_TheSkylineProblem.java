package com.wlw.leetcode2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Q218_TheSkylineProblem {
	private static long totalCount = 0;
	public static void main(String[] args) {
		Q218_TheSkylineProblem test = new Q218_TheSkylineProblem();
		
		Date start = new Date();
		
		int[][] buildings = new int[][]{
			{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}
		};
		//
		Object result = test.getSkyline(buildings);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime())+",totalCount:"+totalCount);
		System.out.println(result);
		List<int[]> result1 = (List<int[]>) result;
		for(int[] arr : result1)	{
			System.out.print(arr[0]+","+arr[1]+"  ");
		}
	}
	public List<int[]> getSkyline(int[][] buildings) {
        Set<Region> set = new TreeSet<Region>();
        set.add(new Region(0,Integer.MAX_VALUE,0));
        for(int i=0;i<buildings.length;i++)	{
        	int from = buildings[i][0];
        	int to = buildings[i][1];
        	int height = buildings[i][2];
        	Set<Region> addSet = new TreeSet<Region>();
        	for(Region region : set)	{
        		if(to <= region.from || from >=region.to || height <= region.height)	{
        			continue;
        		}
        		if(to > region.from && to < region.to && from <= region.from)	{
        			addSet.add(new Region(region.from,to,height));
        			region.from = to;
        			continue;
        		}
        		if(to > region.from && to < region.to && from > region.from)	{
        			addSet.add(new Region(from,to,height));
        			addSet.add(new Region(region.from,from,region.height));
        			region.from = to;
        			continue;
        		}
        		if(to > region.from && to >= region.to && from > region.from)	{
        			addSet.add(new Region(from,to,height));
        			region.to = from;
        			continue;
        		}
        		if(region.from >= to)	{
        			break;
        		}
            }
        	set.addAll(addSet);
        }
        List<int[]> result = new ArrayList<int[]>();
        Region pre = new Region(0,0,0);
        for(Region region : set)	{
        	if(region.height != pre.height)	{
        		result.add(new int[]{region.from,region.height});
        		pre = region;
        	}
        }
        return result;
	}
	public static class Region implements Comparable<Region>	{
		Integer from;
		Integer to;
		Integer height;
		public Region(Integer from,Integer to)	{
			this.from = from;
			this.to = to;
		}
		public Region(Integer from,Integer to,Integer height)	{
			this.from = from;
			this.to = to;
			this.height = height;
		}
		@Override
		public boolean equals(Object obj) {
			Region region = (Region)obj;
			return this.from == region.from && this.to == region.to;
		}
		@Override
		public int hashCode() {
			return from.hashCode()+to.hashCode();
		}
		@Override
		public int compareTo(Region o) {
			if(this.from > o.from)	{
				return 1;
			} else if(this.from == o.from)	{
				if(this.to == o.to)	{
					return 0;
				} else if(this.to > o.to)	{
					return 1;
				}
			}
			return -1;
		}
		@Override
		public String toString() {
			return this.from+"->"+this.to+":"+this.height;
		}
	}
	
}


