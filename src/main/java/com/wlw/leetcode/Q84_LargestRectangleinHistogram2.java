package com.wlw.leetcode;

import java.util.Date;
import java.util.Stack;

public class Q84_LargestRectangleinHistogram2 {

	public static void main(String[] args) {
		Q84_LargestRectangleinHistogram2 test = new Q84_LargestRectangleinHistogram2();
		
		Date start = new Date();
		
		int[] heights = new int[]{5,4,1,2};
		Object result = test.largestRectangleArea(heights);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	//当处理到i时，stack存放的是所有比height[i]小的柱子组成的波峰图
	public int largestRectangleArea(int[] height) {
		int area = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < height.length; i++) {
			if (stack.empty() || height[stack.peek()] < height[i]) {
				stack.push(i);
			} else {
				while(!stack.empty() && height[stack.peek()]>height[i])	{
					int start = stack.pop();
					int width = stack.empty() ? i : i - stack.peek() - 1;  
					area = Math.max(area, height[start] * width);
				}
				stack.push(i);
			}
		}
		while (!stack.empty()) {
			int start = stack.pop();
			int width = stack.empty() ? height.length : height.length - stack.peek() - 1;
			area = Math.max(area, height[start] * width);
		}
		return area;
	}
}

