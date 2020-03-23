package com.wlw.leetcode2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Q295_FindMedianfromDataStream2 {
	private static long totalCount = 0;
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Q295_FindMedianfromDataStream2 test = new Q295_FindMedianfromDataStream2();
		
		Date start = new Date();
		
		
		MedianFinder obj = new MedianFinder();
		obj.addNum(3);
		obj.addNum(2);
		obj.addNum(1);
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime())+",totalCount:"+totalCount);
	}
	
	public static class MedianFinder	{
		private List<Integer> list;
		
		public MedianFinder() {
			list = new ArrayList<Integer>();
	    }
	    public void addNum(int num) {
	    	list.add(searchInsert(list,num), num);
	    }
	    public int searchInsert(List<Integer> list, int target) {
	        int low = 0, high = list.size()-1;
	        while(low<=high){
	            int mid = (low+high)/2;
	            if(list.get(mid) == target) return mid;
	            else if(list.get(mid) > target) high = mid-1;
	            else low = mid+1;
	        }
	        return low;
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

