package com.wlw.leetcode;

import java.util.Date;

public class Q72_EditDistance3 {

	public static void main(String[] args) {
		Q72_EditDistance3 test = new Q72_EditDistance3();
		
		Date start = new Date();
		Object result = test.minDistance("dinitrophenylhydrazine","acetylphenylhydrazine");
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
		
	}
	public int minDistance(String word1, String word2) {
		int n = word1.length();  
        int m = word2.length();  
        //把某些特殊情况的O(n)或O(m)变成O(1)，所以还是值得加两句的。  
        if (n == 0) return m;  
        if (m == 0) return n;  
  
        int[][] table = new int[m+1][n+1];
        for (int i = 0; i <= n; i++) {  
            table[0][i] = i;  
        }  
        for (int i = 0; i <= m; i++)  {  
            table[i][0] = i;  
        }  
  
        for (int i = 1; i <= m; i++)    {  
            for (int j = 1; j <= n; j++)   {  
                if (word2.charAt(i-1) == word1.charAt(j-1))   {  
                    //注意：相同的情况下是直接按前面的方案计算就可以了  
                    //很难想出来的条件  
                    table[i][j] = table[i-1][j-1];  
                } else {  
                    int t = Math.min(table[i-1][j], table[i][j-1]);  
                    table[i][j] = Math.min(t, table[i-1][j-1]);  
                    table[i][j]++;  
                }  
            }  
        }  
        return table[m][n];  
    }  
	
}

