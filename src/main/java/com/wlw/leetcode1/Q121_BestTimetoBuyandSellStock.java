package com.wlw.leetcode1;

import java.util.Date;

public class Q121_BestTimetoBuyandSellStock {

	public static void main(String[] args) {
		Q121_BestTimetoBuyandSellStock test = new Q121_BestTimetoBuyandSellStock();
		
		String str = ""+/**~{*/""
			+ "10000,9999,9998,9997,9996"
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
        int max = 0;
        int maxBuy = Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++)	{
        	if(prices[i] > maxBuy)	{
        		continue;
        	}
        
        	for(int j=i+1;j<prices.length;j++)	{
        		int profit = prices[j]-prices[i];
            	if(profit > max)	{
            		max = profit;
            		maxBuy = prices[i];
            	}
            }
        }
		return max;
    }
}

