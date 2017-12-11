package com.wlw.leetcode2;

import java.util.Date;

public class Q122_BestTimetoBuyandSellStockII {

	public static void main(String[] args) {
		Q122_BestTimetoBuyandSellStockII test = new Q122_BestTimetoBuyandSellStockII();
		
		String str = ""+/**~{*/""
			+ "1,2"
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
		if(prices == null || prices.length == 0)	{
			return 0;
		}
		int totalProfit = 0;
		int maxProfit = 0;
        int buyIndex = 0;
        
        for(int i=1;i<prices.length;i++)	{
        	if(prices[i] > prices[i-1])	{
        		maxProfit = prices[i]-prices[buyIndex];
        	} else {
        		buyIndex = i;
        		totalProfit = totalProfit+maxProfit;
        		maxProfit = 0;
        	}
        	if(i == prices.length-1)	{
        		totalProfit = totalProfit+maxProfit;
        	}
        }
        return totalProfit;
    }
}

