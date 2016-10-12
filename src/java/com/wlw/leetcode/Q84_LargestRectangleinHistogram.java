package com.wlw.leetcode;

import java.util.Date;

public class Q84_LargestRectangleinHistogram {

	public static void main(String[] args) {
		Q84_LargestRectangleinHistogram test = new Q84_LargestRectangleinHistogram();
		
		Date start = new Date();
		
		int[] heights = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1};
		Object result = test.largestRectangleArea(heights);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public int largestRectangleArea(int[] heights) {
        int max = 0;
        int len = heights.length;
        for(int i=0;i<len;i++)	{
        	int curVal = heights[i];
        	int curMax = curVal;
        	for(int m=i-1;m>=0;m--)	{
        		if(heights[m] >= curVal)	{
        			curMax += curVal;
        		} else {
        			break;
        		}
        	}
        	for(int m=i+1;m<len;m++)	{
        		if(heights[m] >= curVal)	{
        			curMax += curVal;
        		} else {
        			break;
        		}
        	}
        	if(curMax > max)	{
        		max = curMax;
        	}
        }
        return max;
    }
}

