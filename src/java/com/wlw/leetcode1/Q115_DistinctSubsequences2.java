package com.wlw.leetcode1;

import java.util.Date;

public class Q115_DistinctSubsequences2 {

	public static void main(String[] args) {
		Q115_DistinctSubsequences2 test = new Q115_DistinctSubsequences2();
		
		Date start = new Date();
		
//		String s = "rabbbt";
//		String t = "rabbt";
//		String s = "bccbcdcabadabddbccaddcbabbaaacdba";
//		String t = "bccbbdc";
//		String s = "abcde";
//		String t = "abc";
		String s = "daacaedaceacabbaabdccdaaeaebacddadcaeaacadbceaecddecdeedcebcdacdaebccdeebcbdeaccabcecbeeaadbccbaeccbbdaeadecabbbedceaddcdeabbcdaeadcddedddcececbeeabcbecaeadddeddccbdbcdcbceabcacddbbcedebbcaccac";
		String t = "ceadbaa";
		
		Object result = test.numDistinct(s,t);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public int numDistinct(String s, String t) {
		if(s==null||t==null) {  
            return 0;  
        }  
        if(s.length()<t.length()) {  
            return 0;  
        }  
        int [][] dp = new int[s.length()+1][t.length()+1];  
        dp[0][0] = 1;  
        //任意一个字符串变换成一个空串都只有一种变换方法  
        for(int i=0;i<s.length();i++) {  
            dp[i][0] = 1;      
        }  
        //递推公式  
        for(int i=1;i<=s.length();i++) {  
            for(int j=1;j<=t.length();j++) {  
                //如果S和T的当前字符相等，那么有两种选法；否则S的当前字符不能要  
                dp[i][j] = dp[i-1][j];  
                if(s.charAt(i-1)==t.charAt(j-1)) {  
                    dp[i][j] += dp[i-1][j-1];  
                }  
            }  
        }  
        return dp[s.length()][t.length()];  
	}
}

