package com.wlw.leetcode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Q52_NQueensII {

	public static void main(String[] args) {
		Q52_NQueensII test = new Q52_NQueensII();
		
		Date start = new Date();
		int n = 9;
		int result = test.totalNQueens(n);
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		
		System.out.println(result);
	}
	public int totalNQueens(int n) {
		List<String> result = new ArrayList<String>();
		int[] cols = new int[n];
		solveNQueensRecu(result,cols, 0, n);
		return result.size();
    }
	public void solveNQueensRecu(List<String> result,int[] cols, int cur, int n) {
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
				result.add("");
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

