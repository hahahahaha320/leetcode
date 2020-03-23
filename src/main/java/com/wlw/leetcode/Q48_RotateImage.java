package com.wlw.leetcode;

import java.util.Date;

public class Q48_RotateImage {

	public static void main(String[] args) {
		Q48_RotateImage test = new Q48_RotateImage();
		
		Date start = new Date();
		
		for(int n=10;n<=10;n++)	{
			int[][] matrix = test.makeMatrix(n);
			
			//test.printMatrix(matrix);
			test.rotate(matrix);
			test.printMatrix(matrix);
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
       	 		int maxIndex = calMaxIndex(i,j,n-1);
       	 		char pos = belongPos(i, j, n, maxIndex);
       	 		if(pos == 't')	{
       	 			matrix[j][maxIndex] = copy[i][j];
       	 		} else if(pos == 'r')	{
       	 			matrix[maxIndex][n-i-1] = copy[i][j];
       	 		} else if(pos == 'd')	{
       	 			matrix[j][n-maxIndex-1] = copy[i][j];
       	 		} else if(pos == 'l')	{
       	 			matrix[j][n-i-1] = copy[i][j];
       	 		}
       	 	}
        }
        
    }
	private int calMaxIndex(int i,int j,int n)	{
		int diff1 = n-i;
		int diff2 = n-j;
		int maxIndex = Math.max(diff1,diff2);
		maxIndex = Math.max(maxIndex,i);
		maxIndex = Math.max(maxIndex,j);
		return maxIndex;
	}
	private char belongPos(int i,int j,int n,int maxIndex)	{
		int minIndex = n-maxIndex-1;
		if(i==minIndex)	{
			return 't';
		} else if(i==maxIndex)	{
			return 'd';
		} else if(j==minIndex)	{
			return 'l';
		} else if(j==maxIndex)	{
			return 'r';
		}
		return 'x';
	}
}
