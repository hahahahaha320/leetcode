package com.wlw.leetcode;

import java.util.Date;

public class Q97_InterleavingString {

	public static void main(String[] args) {
		Q97_InterleavingString test = new Q97_InterleavingString();
		
		Date start = new Date();
		
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
//		String s3 = "aadbbbaccc";
		Object result = test.isInterleave(s1,s2,s3);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public boolean isInterleave(String s1, String s2, String s3) {  
		if (s1.length() + s2.length() != s3.length()) return false;  
        boolean[][] dp = new boolean[s2.length() + 1][s1.length() + 1];  
        dp[0][0] = true;  
        for (int j = 1; j <= s1.length(); j++) {  
            dp[0][j] = dp[0][j - 1] && (s1.charAt(j - 1) == s3.charAt(j - 1));  
        }  
        for (int i = 1; i <= s2.length(); i++) {  
            dp[i][0] = dp[i - 1][0] && (s2.charAt(i - 1) == s3.charAt(i - 1));  
        }  
        for (int i = 1; i <= s2.length(); i++) {  
            for ( int j = 1; j <= s1.length(); j++) {  
                dp[i][j] = dp[i - 1][j] && (s2.charAt(i - 1) == s3.charAt(i + j - 1))  
                        || dp[i][j - 1] && (s1.charAt(j - 1) == s3.charAt(i + j - 1));  
            }  
        }  
        return dp[s2.length()][s1.length()];  
    }
}

