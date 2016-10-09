package com.wlw.leetcode;

import java.util.Date;

public class Q74_Searcha2DMatrix {

	public static void main(String[] args) {
		Q74_Searcha2DMatrix test = new Q74_Searcha2DMatrix();
		
		Date start = new Date();
		
		int[][] matrix = new int[][]{{1}};
		Object result = test.searchMatrix(matrix,0);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public boolean searchMatrix(int[][] matrix, int target) {
		int m=matrix.length;
        int n=matrix[0].length;
        int end = m*n-1;
        int start = 0;
        while(true)	{
        	if(start>end)	{
        		return false;
        	}
        	int mid = (end+start)/2;
        	int i = mid/n;
        	int j = mid-n*i;
        	if(matrix[i][j] == target)	{
        		return true;
        	}
        	if(matrix[i][j] > target)	{
        		end = mid-1;
        	} else {
        		start = mid+1;
        	}
        }
    }
}

