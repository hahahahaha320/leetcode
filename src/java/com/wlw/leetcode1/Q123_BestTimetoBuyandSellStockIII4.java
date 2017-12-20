package com.wlw.leetcode1;

import java.util.Date;

public class Q123_BestTimetoBuyandSellStockIII4 {
	/**
	 * 容易想到的想法是暴力解决，分成两边，一边一个交易，取最大值。
	 * 这个想法的优化方法是去掉中间不需要的price，减小prices的规模，比如 1,2,3,5  就可以把2,3去掉而不影响结果。
	 * 
	 * 最好的方法是用动态规划，不过理解起来有难度。
	 * @param args
	 */
	public static void main(String[] args) {
		Q123_BestTimetoBuyandSellStockIII4 test = new Q123_BestTimetoBuyandSellStockIII4();
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
	public int maxProfit2(int[] prices) {
        if(prices.length < 2)  return 0;
        int[] profit = new int[prices.length];
        for(int k=0; k<2; k++) {
            int maxBuy = profit[0] - prices[0];
            for(int i=1; i<prices.length; i++) {
                int tmp = profit[i];
                profit[i] = Math.max(profit[i-1], maxBuy + prices[i]);
                maxBuy = Math.max(maxBuy, tmp - prices[i]);
            }
        }
        return profit[prices.length - 1];
    }
	public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int n = prices.length;
        int[][] g = new int[n][3];
        int[][] l = new int[n][3];
        for (int i = 1; i < prices.length; ++i) {
            int diff = prices[i] - prices[i - 1];
            for (int j = 1; j <= 2; ++j) {
                l[i][j] = Math.max(g[i - 1][j - 1] + Math.max(diff, 0), l[i - 1][j] + diff);
                g[i][j] = Math.max(l[i][j], g[i - 1][j]);
            }
        }
        return g[n - 1][2];
    }
}

