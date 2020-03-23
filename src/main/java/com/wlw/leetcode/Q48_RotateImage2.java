package com.wlw.leetcode;

import java.util.Date;

public class Q48_RotateImage2 {

	public static void main(String[] args) {
		Q48_RotateImage2 test = new Q48_RotateImage2();
		
		Date start = new Date();
		
		for(int n=10;n<=10;n++)	{
			int[][] matrix = test.makeMatrix(n);
			
			//test.printMatrix(matrix);
			test.rotate(matrix);
			//test.printMatrix(matrix);
		}
		
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		//System.out.println(matrix);
	}
	private int[][] makeMatrix(int n)	{
		int[][] matrix = new int[n][n];
		int val=1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = val++;
			}
		}
		return matrix;
	}
	
	public void printMatrix(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(String.format("%4d", matrix[i][j]));
			}
			System.out.println("\n");
		}
		System.out.println("");
	}
	
	
	
	//为追求效率，函数全部内联
	public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] copy = new int[n][n];
        for(int i=0;i<n;i++)	{
        	 for(int j=0;j<n;j++)	{
        		 copy[i][j] = matrix[i][j];
        	 }
        }
        for(int i=0;i<n;i++)	{
       	 	for(int j=0;j<n;j++)	{
	       	 	int diff1 = n-1-i;
	    		int diff2 = n-1-j;
	    		int maxIndex = diff1>diff2?diff1:diff2;
	    		maxIndex = maxIndex>i?maxIndex:i;
	    		maxIndex = maxIndex>j?maxIndex:j;
	       	 	int minIndex = n-maxIndex-1;
       	 		if(i==minIndex)	{
       	 			matrix[j][maxIndex] = copy[i][j];
       	 		} else if(j==maxIndex)	{
       	 			matrix[maxIndex][n-i-1] = copy[i][j];
       	 		} else if(i==maxIndex)	{
       	 			matrix[j][n-maxIndex-1] = copy[i][j];
       	 		} else if(j==minIndex)	{
       	 			matrix[j][n-i-1] = copy[i][j];
       	 		}
       	 	}
        }
    }
}
