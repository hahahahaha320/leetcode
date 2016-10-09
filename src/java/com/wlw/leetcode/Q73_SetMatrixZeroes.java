package com.wlw.leetcode;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Q73_SetMatrixZeroes {

	public static void main(String[] args) {
		Q73_SetMatrixZeroes test = new Q73_SetMatrixZeroes();
		
		Date start = new Date();
		
		int[][] matrix = new int[][]{{0,1}};
		Util.printMatrix(matrix);
		test.setZeroes(matrix);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		
		Util.printMatrix(matrix);
	}
	public void setZeroes(int[][] matrix) {
        Set<Integer> zeroRowSet = new HashSet<Integer>();
        Set<Integer> zeroColSet = new HashSet<Integer>();
        int m=matrix.length;
        int n=matrix[0].length;
        for(int i=0;i<m;i++)	{
        	for(int j=0;j<n;j++)	{
            	if(matrix[i][j] == 0)	{
            		zeroRowSet.add(i);
            		zeroColSet.add(j);
            	}
            }
        }
        for(int pos: zeroRowSet)	{
        	for(int j=0;j<n;j++)	{
    			matrix[pos][j] =0;
    		}
        }
        for(int pos: zeroColSet)	{
        	for(int j=0;j<m;j++)	{
    			matrix[j][pos] =0;
    		}
        }
	}
}

