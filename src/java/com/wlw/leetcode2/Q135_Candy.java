package com.wlw.leetcode2;

import java.util.Date;

public class Q135_Candy {
	private static long totalCount = 0;
	public static void main(String[] args) {
		Q135_Candy test = new Q135_Candy();
		
		Date start = new Date();
		
		int[] ratings = new int[]{1,2,2};
		Object result = test.candy(ratings);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime())+",totalCount:"+totalCount);
		System.out.println(result);
	}
	public int candy(int[] ratings) {
		int[] result = new int[ratings.length];
		if(ratings.length == 1)	{
			return 1;
		}
		if(ratings[0] <= ratings[1])	{
			result[0]  = 1;
		}
		for(int i=1;i<ratings.length-1;i++)	{
			if(ratings[i] <= ratings[i+1] && ratings[i] <= ratings[i-1])	{
				result[i]  = 1;
				continue;
			} 
			if(ratings[i] > ratings[i-1] && ratings[i] <= ratings[i+1] && result[i-1] != 0)	{
				result[i]  = result[i-1] + 1;
			}
		}
		if(ratings[ratings.length-1] <= ratings[ratings.length-2])	{
			result[ratings.length-1]  = 1;
		}
		if(ratings[ratings.length-1] > ratings[ratings.length-2] && result[ratings.length-2] != 0)	{
			result[ratings.length-1]  = result[ratings.length-2] + 1;
		}
		for(int i=ratings.length-2;i>0;i--)	{
			if(ratings[i] > ratings[i+1] && ratings[i] <= ratings[i-1] && result[i+1] != 0)	{
				result[i]  = result[i+1] + 1;
			}
			if(ratings[i] > ratings[i+1] && ratings[i] > ratings[i-1] && result[i+1] != 0&& result[i-1] != 0)	{
				result[i]  = Math.max(result[i+1],result[i-1])+1;
			}
		}
		if(result[0] == 0)	{
			result[0] = result[1]+1;
		}
		int resultTotal = 0;
		for(int num : result)	{
			//System.out.print(num+",");
			resultTotal+=num;
		}
		//System.out.println();
		return resultTotal;
    }
}

