package com.wlw.leetcode2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Q123_BestTimetoBuyandSellStockIII3 {

	public static void main(String[] args) {
		Q123_BestTimetoBuyandSellStockIII3 test = new Q123_BestTimetoBuyandSellStockIII3();
		//2,1,2,1,0,0,1
		String str = ""+/**~{*/""
			+ "2,1,2,1,0,0,1"
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
	private int findUpIndex(int[] prices,int from) {
		for(int i=from;i<prices.length-1;i++)	{
			if(prices[i] < prices[i+1])	{
				return i;
			}
		}
		return -1;
	}
	private int findDownIndex(int[] prices,int from) {
		for(int i=from;i<prices.length-1;i++)	{
			if(prices[i] > prices[i+1])	{
				return i;
			}
		}
		return prices.length-1;
	}
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length <= 1)	{
			return 0;
		}
		
		List<Integer> list = new ArrayList<Integer>();
		
		int upIndex = -1;
		int downIndex = -1;
		while(true){
			upIndex = findUpIndex(prices, downIndex+1);
			if(upIndex < 0)	{
				break;
			}
			downIndex = findDownIndex(prices,upIndex+1);
			if(downIndex < 0)	{
				break;
			}
			list.add(upIndex);
			list.add(downIndex);
		}
		System.out.println(list);
		
		int priceArr[] = new int[list.size()];
		for(int i=0;i<list.size();i++)	{
			priceArr[i] = prices[list.get(i)];
		}
		int max = 0;
		for(int i=0;i<priceArr.length;i=i+2)	{
			int profit = maxProfitOnce(priceArr,0,i-1) + maxProfitOnce(priceArr,i,priceArr.length-1);
			if(profit > max)	{
				max = profit;
			}
		}
		return max;
	}
	public int maxProfitOnce(int[] prices,int from,int to) {
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
        	}
        }
        return maxProfit;
	}
}

