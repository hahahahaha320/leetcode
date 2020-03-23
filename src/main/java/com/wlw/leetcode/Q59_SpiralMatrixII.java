package com.wlw.leetcode;

import java.util.Date;

public class Q59_SpiralMatrixII {

	public static void main(String[] args) {
		Q59_SpiralMatrixII test = new Q59_SpiralMatrixII();
		
		Date start = new Date();
		
		int n=5;
		int[][] result = test.generateMatrix(n);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
		for(int i=0;i < n;i++)	{
			for(int j=0;j<n;j++)	{
				System.out.print(result[i][j] + ", ");
			}
			System.out.println();
		}
	}
	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		int row = n;
		int col = n;
		int tx=0,ty=0;
		int curValue = 1;
		while(row>0&&col>0)	{
			int x=tx,y=ty;
			for(int i=0;i<col;i++)	{
				matrix[x][y] = curValue++;
				if(i<col-1)	{
					y++;
				}
			}
			if(row==1)	{
				break;
			}
			x++;
			for(int i=0;i<row-1;i++)	{
				matrix[x][y] = curValue++;
				if(i<row-2)	{
					x++;
				}
			}
			if(col==1)	{
				break;
			}
			y--;
			for(int i=0;i<col-1;i++)	{
				matrix[x][y] = curValue++;
				if(i<col-2)	{
					y--;
				}
			}
			x--;
			for(int i=0;i<row-2;i++)	{
				matrix[x][y] = curValue++;
				x--;
			}
			row-=2;
			col-=2;
			tx++;
			ty++;
		}
		return matrix;
    }
}

