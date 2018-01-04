package com.wlw.leetcode;

import java.util.Date;

import com.wlw.leetcode.util.Util;

public class Q34_SearchforaRange {

	public static void main(String[] args) {
		Q34_SearchforaRange test = new Q34_SearchforaRange();
		
		Date start = new Date();
		
		int[] nums = new int[]{1};
		int[] result = test.searchRange(nums,1);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		Util.printArray(result);
	}
	public int[] searchRange(int[] nums, int target) {
		int start = 0;
		int end = nums.length-1;
		int media = 0;
		while(true)	{
			media = (start+end)/2;
			if(nums[media] ==  target)	{
				break;
			} else if(nums[media] >  target) {
				end = media-1;
			} else {
				start = media+1;
			}
			if(start > end)	{
				media = -1;
				break;
			}
		}
		if(media == -1)	{
			return new int[]{-1,-1};
		}
		int from = media,to = media;
		while(from>=0 && nums[from] == target)	{
			from--;
		}
		while(to<=nums.length-1 && nums[to] == target)	{
			to++;
		}
		return new int[]{from+1,to-1}; 
    }
    
}

