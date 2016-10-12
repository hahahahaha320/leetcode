package com.wlw.leetcode;

import java.util.Date;
import java.util.Stack;

public class Q85_MaximalRectangle {

	public static void main(String[] args) {
		Q85_MaximalRectangle test = new Q85_MaximalRectangle();
		
		Date start = new Date();
		
		char[][] matrix = new char[][]{{'1','0','1','0','0'},
									{'1','0','1','1','1'},
									{'1','1','1','1','1'},
									{'1','0','0','1','0'}};
		Object result = test.maximalRectangle(matrix);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	
	public int maximalRectangle(char[][] matrix) {
		int m = matrix.length;
		if(m==0)	{
			return 0;
		}
		int n = matrix[0].length;
		int[] height = new int[n];
		int max = 0;
		for(int i=0;i<m;i++)	{
			for(int j=0;j<n;j++)	{
				if(matrix[i][j] == '0')	{
					height[j] = 0;
				} else {
					height[j]++;
				}
			}
			int curMax = largestRectangleArea(height);
			if(max < curMax)	{
				max = curMax;
			}
		}
		return max;
		
	}
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

