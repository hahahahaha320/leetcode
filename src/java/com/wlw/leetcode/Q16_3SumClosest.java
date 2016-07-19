package com.wlw.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Q16_3SumClosest {

	public static void main(String[] args) {
		Q16_3SumClosest test = new Q16_3SumClosest();
		
		Date start = new Date();
		
		//int[] date = new int[]{7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
		int[] date = new int[]{0,2,1,-3};
		
		int result = test.threeSumClosest(date,1);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public int threeSumClosest(int[] nums, int target) {
		int result = nums[0]+nums[1]+nums[2];
		long interval = Math.abs(result-target);
		
		List<Integer> numList = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++)	{
        	numList.add(nums[i]);
        }
        Collections.sort(numList);
        
        for(int i=0;i<nums.length-2;i++)	{
        	int j=i+1;
        	int k=numList.size()-1;
        	while(j<k)	{
        		int sum = numList.get(i)+numList.get(j)+numList.get(k);
        		int inter =  sum-target;
        		if(Math.abs(inter)<interval)	{
        			interval=Math.abs(inter);
        			result = sum;
        		}
        		if(inter == 0)	{
        			return target;
        		} else if(inter > 0)	{
        			k--;
        		} else {
        			j++;
        		}
        	}
        }
        return result;
    }
}

