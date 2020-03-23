package com.wlw.leetcode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Q51_NQueens2 {

	public static void main(String[] args) {
		Q51_NQueens2 test = new Q51_NQueens2();
		
		Date start = new Date();
		int n = 1;
		List<List<String>> result = test.solveNQueens(n);
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		
		for(List<String> oneWay : result)	{
			for(String oneLine : oneWay)	{
				System.out.println(oneLine);
			}
			System.out.println("__________");
		}
		System.out.println(result.size());
	}
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<List<String>>();
		int[] cols = new int[n];
		solveNQueensRecu(result,cols, 0, n);
        return result;
    }

	public void solveNQueensRecu(List<List<String>> result,int[] cols, int cur, int n) {
		boolean[] rows = new boolean[n];
		for (int i = 0; i < cur; i++) {
			rows[cols[i]] = true;
			int d = cur - i;
			if (cols[i] - d >= 0) rows[cols[i] - d] = true;
			if (cols[i] + d <= n - 1) rows[cols[i] + d] = true;
		}
		for (int i = 0; i < n; i++) {
			if (rows[i]) continue;
			cols[cur] = i;
			if (cur < n - 1) {
				solveNQueensRecu(result,cols, cur + 1, n);
			} else {
				List<String> oneWay = new ArrayList<String>();
				 for(int p=0;p<n;p++){ 
					 String oneLine = "";
			         for(int q=0;q<n;q++){  
			           if(p==cols[q]){  
			        	   oneLine += "Q";
			           }else  
			        	   oneLine += ".";
			         } 
			         oneWay.add(oneLine);
				 }
				result.add(oneWay);
			}
		}
	}
	
	
	public void printChessBoard(int[] cols, int n) {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == cols[j]) {
					System.out.print("0 ");
				} else
					System.out.print("+ ");
			}
			System.out.println();
		}
		System.out.println("              ");
	}
}

