package com.wlw.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q15_3Sum2 {

	public static void main(String[] args) {
		Q15_3Sum2 test = new Q15_3Sum2();
		
		Date start = new Date();
		
		//int[] date = new int[]{7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
		int[] date = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
		
		List<List<Integer>> result = test.threeSum(date);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums.length < 3)	{
			return result;
		}
		List<Integer> numList = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++)	{
        	numList.add(nums[i]);
        }
        Collections.sort(numList);
        
        Set<String> set = new HashSet<String>(); 
        for(int i=0;i<nums.length-2;i++)	{
        	if(numList.get(i) > 0)	{
        		break;
        	}
        	Integer need = -(numList.get(i));
        	int j=i+1;
        	int k=numList.size()-1;
        	while(j<k)	{
        		int num = numList.get(j)+numList.get(k);
        		if(num == need)	{
        			String key = numList.get(i)+"," +numList.get(j)+","+numList.get(k);
        			if(!set.contains(key))	{
        				List<Integer> list = new ArrayList<Integer>();
            			list.add(numList.get(i));
            			list.add(numList.get(j));
            			list.add(numList.get(k));
            			result.add(list);
            			set.add(key);
        			} 
        			k--;
        			j++;
        			
        		} else if(num > need)	{
        			k--;
        		} else {
        			j++;
        		}
        	}
        }
        return result;
    }
}

