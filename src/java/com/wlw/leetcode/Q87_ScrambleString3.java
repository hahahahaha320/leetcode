package com.wlw.leetcode;

import java.util.Date;

public class Q87_ScrambleString3 {

	public static void main(String[] args) {
		Q87_ScrambleString3 test = new Q87_ScrambleString3();
		
		Date start = new Date();
		
//		Object result = test.isScramble("great","reatg");
		Object result = test.isScramble("abcdefghijklmnopq","efghijklmnopqcadb");
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public boolean isScramble(String s1, String s2) {  
		int length = s1.length();
        if (length != s2.length()) return false;  
        if (s1.equals(s2)) return true;  
        
        boolean[][][] dp = new boolean[length][s2.length()][length + 1];  
        for (int i = 0; i < length; i++) {  
            for (int j = 0; j < s2.length(); j++) {  
                dp[i][j][1] = s1.charAt(i) == s2.charAt(j);  
            }  
        }  
        for (int len = 2; len <= length; len++) {  
            for (int i = 0; i < length - len + 1; i++) {  
                for (int j = 0; j < s2.length() - len + 1; j++) {  
                    for (int k = 1; k < len; k++) {  
                        dp[i][j][len] |= dp[i][j][k] && dp[i + k][j + k][len - k] || dp[i][j + len - k][k] && dp[i + k][j][len - k];  
                    }  
                }  
            }  
        }  
        return dp[0][0][length];  
    }
}

