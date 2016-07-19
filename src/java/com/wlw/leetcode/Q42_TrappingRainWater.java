package com.wlw.leetcode;

import java.util.Date;

public class Q42_TrappingRainWater {

	public static void main(String[] args) {
		Q42_TrappingRainWater test = new Q42_TrappingRainWater();
		
		Date start = new Date();
		
		int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
		int result = test.trap(height);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public int trap(int[] height) {
        int preMax = 0;
        int posMax = -1;
        int posMaxIndex = -1;
        int water = 0;
        for(int i=0;i<height.length;i++)	{
        	if(height[i] >= posMax)	{
        		posMax = height[i];
        		posMaxIndex = i;
        	}
        }
        for(int i=0;i<height.length-1;i++)	{
        	int curWater = Math.min(preMax, posMax)-height[i];
        	water = water + Math.max(curWater,0);
        	if(height[i] > preMax)	{
        		preMax = height[i];
        	}
        	if(i == posMaxIndex)	{
        		posMax = -1;
                posMaxIndex = -1;
        		for(int j=i+1;j<height.length;j++)	{
        			if(height[j] >= posMax)	{
        				posMax = height[j];
                		posMaxIndex = j;
        			}
        		}
        	}
        }
		return water;
    }
}

