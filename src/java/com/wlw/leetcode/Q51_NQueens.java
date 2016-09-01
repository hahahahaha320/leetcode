package com.wlw.leetcode;

import java.util.Date;
import java.util.List;

public class Q51_NQueens {

	public static void main(String[] args) {
		Q51_NQueens test = new Q51_NQueens();
		
		Date start = new Date();
		int n = 8;
		List<List<String>> result = test.solveNQueens(n);
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	
	public List<List<String>> solveNQueens(int n) {
        return null;
    }

}

