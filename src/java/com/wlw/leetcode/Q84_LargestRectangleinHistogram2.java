package com.wlw.leetcode;

import java.util.Date;

public class Q84_LargestRectangleinHistogram2 {

	public static void main(String[] args) {
		Q84_LargestRectangleinHistogram2 test = new Q84_LargestRectangleinHistogram2();
		
		Date start = new Date();
		
		int[] heights = new int[]{1,1,1,1,1,1};
		Object result = test.largestRectangleArea(heights);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public int largestRectangleArea(int[] height) {  
		  int area = 0;  
		  java.util.Stack<Integer> stack = new java.util.Stack<Integer>();  
		  for (int i = 0; i < height.length; i++) {  
		    if (stack.empty() || height[stack.peek()] < height[i]) {  
		      stack.push(i);  
		    } else {  
		      int start = stack.pop();  
		      int width = stack.empty() ? i : i - stack.peek() - 1;  
		      area = Math.max(area, height[start] * width);  
		      i--;  
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

