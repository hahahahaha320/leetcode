package com.wlw.leetcode1;

import java.util.Date;

public class Q121_BestTimetoBuyandSellStock3 {

	public static void main(String[] args) {
		Q121_BestTimetoBuyandSellStock3 test = new Q121_BestTimetoBuyandSellStock3();
		
		String str = ""+/**~{*/""
			+ "10000,9999,9998,9997,9996"
			+ "\r\n"
		+ "\r\n"/**}*/;
		
		str = str.replace("\r","");
		str = str.replace("\n","");
		String[] sa = str.split(",");
		
		int[] prices = new int[sa.length];
		for(int i=0;i<sa.length;i++)	{
			prices[i] = Integer.parseInt(sa[i]);
		}
		
		Date start = new Date();
		Object result = test.maxProfit(prices);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i=0;i<prices.length;i++)	{
        	if(prices[i]<minPrice)	{
        		minPrice = prices[i];
        	}
        	if( prices[i] - minPrice > maxProfit)	{
        		maxProfit = prices[i] - minPrice;
        	}
        }
        return maxProfit;
    }
}

