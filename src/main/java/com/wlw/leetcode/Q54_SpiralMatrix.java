package com.wlw.leetcode;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Q54_SpiralMatrix {

	public static void main(String[] args) {
		Q54_SpiralMatrix test = new Q54_SpiralMatrix();
		
		Date start = new Date();
		
		int[][] matrix = {{1,2},{3,4}};
		List<Integer> result = test.spiralOrder(matrix);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new LinkedList<Integer>();
		int row = matrix.length;
		if(row==0)	{
			return result;
		}
		int col = matrix[0].length;
		int tx=0,ty=0;
		while(row>0&&col>0)	{
			int x=tx,y=ty;
			for(int i=0;i<col;i++)	{
				result.add(matrix[x][y]);
				if(i<col-1)	{
					y++;
				}
			}
			if(row==1)	{
				break;
			}
			x++;
			for(int i=0;i<row-1;i++)	{
				result.add(matrix[x][y]);
				if(i<row-2)	{
					x++;
				}
			}
			if(col==1)	{
				break;
			}
			y--;
			for(int i=0;i<col-1;i++)	{
				result.add(matrix[x][y]);
				if(i<col-2)	{
					y--;
				}
			}
			x--;
			for(int i=0;i<row-2;i++)	{
				result.add(matrix[x][y]);
				x--;
			}
			row-=2;
			col-=2;
			tx++;
			ty++;
		}
		return result;
    }
}

