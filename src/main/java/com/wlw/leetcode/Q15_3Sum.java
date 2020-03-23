package com.wlw.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Q15_3Sum {

	public static void main(String[] args) {
		Q15_3Sum test = new Q15_3Sum();
		
		Date start = new Date();
		
		List<List<Integer>> result = test.threeSum(new int[]{7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6});
		
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
		Map<Integer,Integer> numMap = new HashMap<Integer,Integer>(); 
        for(int i=0;i<nums.length;i++)	{
        	numList.add(nums[i]);
        	if(numMap.get(nums[i]) != null)	{
        		numMap.put(nums[i], numMap.get(nums[i])+1);
        	} else {
        		numMap.put(nums[i], 1);
        	}
        }
        Collections.sort(numList);
        Set<String> set = new HashSet<String>(); 
        for(int i=0;i<nums.length-2;i++)	{
        	if(numList.get(i) > 0)	{
        		break;
        	}
        	for(int j=i+1;j<nums.length-1;j++)	{
        		Integer need = -(numList.get(i)+numList.get(j));
        		if(numMap.containsKey(need))	{
        			numMap.put(numList.get(i), numMap.get(numList.get(i))-1);
        			numMap.put(numList.get(j), numMap.get(numList.get(j))-1);
        			
        			int num = numMap.get(need);
        			numMap.put(numList.get(i), numMap.get(numList.get(i))+1);
        			numMap.put(numList.get(j), numMap.get(numList.get(j))+1);
        			if(num <= 0 || need < numList.get(j))	{
        				continue;
        			}
        			String key = numList.get(i)+"," +numList.get(j)+","+need;
        			if(set.contains(key))	{
        				continue;
        			}
        			set.add(key);
        			List<Integer> list = new ArrayList<Integer>();
        			list.add(numList.get(i));
        			list.add(numList.get(j));
        			list.add(need);
        			
        			result.add(list);
        		}
            }
        }
        return result;
    }
}

