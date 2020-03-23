package com.wlw.leetcode2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Q295_FindMedianfromDataStream {
	private static long totalCount = 0;
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Q295_FindMedianfromDataStream test = new Q295_FindMedianfromDataStream();
		
		Date start = new Date();
		
		
		MedianFinder obj = new MedianFinder();
		obj.addNum(1);
		obj.addNum(3);
		obj.addNum(0);
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime())+",totalCount:"+totalCount);
	}
	
	public static class MedianFinder	{
		private List<Integer> list;
		
		public MedianFinder() {
			list = new ArrayList<Integer>();
	    }
	    public void addNum(int num) {
	    	int left = 0,right = list.size()-1;
	    	int pos = (left+right)/2;
	    	while(true)	{
	    		if(right < left || list.get(pos) == num)	{
	    			break;
	    		}
	    		if(left == right)	{
	    			if(list.get(left) <= num)	{
	    				pos++;
	    			} 
	    			break;
	    		}
	    		if(left == right-1)	{
	    			if(list.get(right) <= num)	{
	    				pos = pos+2;
	    			} else if(list.get(left) >= num)	{
	    				
	    			} else {
	    				pos++;
	    			}
	    			break;
	    		}
	    		if(list.get(pos) >= num)	{
	    			right = pos;
	    		} else	{
	    			left = pos;
	    		}
	    		pos = (left+right)/2;
	    	}
	    	list.add(pos, num);
	    }
	    public double findMedian() {
	    	int len = list.size();
	    	if(len == 0)	{
	    		return 0;
	    	}
	    	if(len%2 == 1)	{
	    		return list.get(len/2);
	    	} else {
	    		return (list.get(len/2)+list.get(len/2-1))/2f;
	    	}
	    }
	}
}

