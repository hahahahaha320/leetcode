package com.wlw.leetcode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Q89_GrayCode {

	public static void main(String[] args) {
		Q89_GrayCode test = new Q89_GrayCode();
		
		Date start = new Date();
		for(int i=0;i<12;i++)	{
			test.grayCode(0);
		}
		//Object result = test.grayCode(0);
		
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		//System.out.println(result);
		
	}
	public List<Integer> grayCode(int n) {
		if(n==0)	{
			List<Integer> result = new ArrayList<Integer>();
			result.add(0);
			return result;
		}
		byte[][] arr = new byte[(int)Math.pow(2,n)][n];
		arr[0][0] = 0;
		arr[1][0] = 1;
		for(int i=2;i<=n;i++)	{
			int rowNum = (int)Math.pow(2,i-1);
			for(int j=0;j<rowNum;j++)	{
				System.arraycopy(arr[j],0,arr[rowNum*2-1-j],0,i-1);
			}
			for(int j=0;j<rowNum*2;j++)	{
				arr[j][i-1] = (byte) (j/rowNum);
			}
		}
		int[] weight = new int[n];
		weight[0] = 1;
		for(int i=1;i<n;i++)	{
			weight[i] = 2* weight[i-1];
		}
		List<Integer> result = new ArrayList<Integer>();
		for(int i=0;i<arr.length;i++)	{
			int num = 0;
			for(int j=0;j<n;j++)	{
				if(arr[i][j] == 1)	{
					num+=weight[j];
				}
			}
			result.add(num);
		}
		return result;
    }
	
	
}

