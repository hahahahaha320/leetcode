package com.wlw.leetcode1;

import java.util.Date;

public class Q121_BestTimetoBuyandSellStock2 {

	public static void main(String[] args) {
		Q121_BestTimetoBuyandSellStock2 test = new Q121_BestTimetoBuyandSellStock2();
		
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
	//动态规划的思考方式是：假设已经知道了较小规模问题的答案A(i)，然后增加一个元素的情况下，
	//问题的答案A(i+1)如何能够从A(i)推导出来，也就是得到递推公式，也就是状态转移公式。
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length == 0)	{
			return 0;
		}
        int curSellMax = 0;
        int globalMax = 0;
        for(int i=1;i<prices.length;i++)	{
        	curSellMax = Math.max(prices[i]-prices[i-1]+curSellMax,0);
        	globalMax = Math.max(curSellMax,globalMax);
        }
        return globalMax;
    }
}

