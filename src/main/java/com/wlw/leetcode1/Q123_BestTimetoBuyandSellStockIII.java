package com.wlw.leetcode1;

import java.util.Date;

@Deprecated
public class Q123_BestTimetoBuyandSellStockIII {
	//此解法有问题，启用
	public static void main(String[] args) {
		Q123_BestTimetoBuyandSellStockIII test = new Q123_BestTimetoBuyandSellStockIII();
		
		String str = ""+/**~{*/""
			+ "3,4,6,0,3,7,5,8,2,9,1,6,6,2"
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
		int[] pos = new int[2];
		int max = maxProfitPart(prices,pos);
		int max1 = maxProfitOnce(prices,0,pos[0]-1,null);
		int max2 = maxProfitOnce(prices,pos[1]+1,prices.length-1,null);
		
		int maxFirst = max+Math.max(max1,max2);
		
		max = maxProfitOnce(prices,0,prices.length-1,pos);
		max1 = maxProfitOnce(prices,0,pos[0]-1,null);
		max2 = maxProfitOnce(prices,pos[1]+1,prices.length-1,null);
		
		int maxSecond = max+Math.max(max1,max2);
		
		return Math.max(maxFirst, maxSecond);
	}
	public int maxProfitOnce(int[] prices,int from,int to,int[] pos) {
		if(to-from < 1)	{
			return 0;
		}
		int minIndex = from;
        int maxProfit = 0;
        for(int i=from+1;i<=to;i++)	{
        	if(prices[i]<prices[minIndex])	{
        		minIndex = i;
        	}
        	if(prices[i] - prices[minIndex] > maxProfit)	{
        		maxProfit = prices[i] - prices[minIndex];
        		if(pos != null)	{
            		pos[0] = minIndex;
            		pos[1] = i;
        		}
        		
        	}
        }
        return maxProfit;
	}
	public int maxProfitPart(int[] prices,int[] pos) {
		if(prices == null || prices.length == 0)	{
			return 0;
		}
		int curMaxProfit = 0;
        int buyIndex = 0;
        int totMaxProfit = 0;
        
        for(int i=1;i<prices.length;i++)	{
        	if(prices[i] > prices[i-1])	{
        		curMaxProfit = prices[i]-prices[buyIndex];
        		if(curMaxProfit > totMaxProfit)	{
        			pos[0] = buyIndex;
            		pos[1] = i;
            		totMaxProfit = curMaxProfit;
        		}
        		
        	} else {
        		buyIndex = i;
        	}
        }
        return totMaxProfit;
    }
	
	
	
	/*
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length == 0)	{
			return 0;
		}
		int maxProfit = 0;
		int maxProfit2 = 0;
        int buyIndex = 0;
        int curProfit = 0;
        
        for(int i=1;i<prices.length;i++)	{
        	if(prices[i] > prices[i-1])	{
        		curProfit = prices[i]-prices[buyIndex];
        	}
        	if(prices[i] < prices[i-1] || i == prices.length-1){
        		if(curProfit > maxProfit)	{
        			maxProfit2 = maxProfit;
        			maxProfit = curProfit;
        		} else if(curProfit > maxProfit2)	{
        			maxProfit2 = curProfit;
        		}
        		buyIndex = i;
        		curProfit = 0;
        	}
        }
        return maxProfit+maxProfit2;
    }
    */
}

