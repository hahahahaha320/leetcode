package com.wlw.leetcode;

import java.util.Date;

public class Q11_ContainerWithMostWater {

	public static void main(String[] args) {
		Q11_ContainerWithMostWater test = new Q11_ContainerWithMostWater();
		
		Date start = new Date();
		int[] height = new int[]{1,2,3,4};
		Integer result = test.maxArea(height);
		System.out.println(result);
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public int maxArea(int[] height) {
        int max = 0;
        int left = 0,right=height.length-1;
        while(left < right)	{
        	int area = (right-left)*Math.min(height[left],height[right]);
        	max = Math.max(max, area);
        	if(height[left] < height[right])	{
        		left++;
        	} else {
        		right--;
        	}
        }
        return max;
    }
}

