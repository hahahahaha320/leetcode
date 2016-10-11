package com.wlw.leetcode;

import java.util.Date;

public class Q79_WordSearch {

	public static void main(String[] args) {
		Q79_WordSearch test = new Q79_WordSearch();
		
		Date start = new Date();
		
		char[][] board = new char[][]{  {'A','B','C','E'},
				  						{'S','F','E','S'},
				  						{'A','D','E','E'}};
		//SEE  ABCB
		Object result = test.exist(board,"ABCESEEEF");

		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public boolean exist(char[][] board, String word) {
		int m=board.length;
        int n=board[0].length;
        
        boolean suc = false;
        for(int i=0;i<m;i++)	{
        	for(int j=0;j<n;j++)	{
        		if(board[i][j] == word.charAt(0))	{
        			boolean[][] gone = new boolean[m][n];
            		suc = suc || go(board, m, n, i, j, word, gone);
            	}
        	}
        }
        return suc;
    }
	
	public boolean go(char[][] board,int m,int n,int startRow,int startCol,String word,boolean[][] gone)	{
		if(word.length() == 1 && board[startRow][startCol] == word.charAt(0))	{
			return true;
		}
		if(board[startRow][startCol] != word.charAt(0))	{
			return false;
		}
		gone[startRow][startCol]=true;
		
		boolean suc = false;
		//向右
		if(startCol < n-1 && !gone[startRow][startCol+1]
				&& board[startRow][startCol+1] ==  word.charAt(1))	{
			suc = suc || go(board, m, n, startRow, startCol+1, word.substring(1), gone);
		}
		//向左
		if(startCol > 0 && !gone[startRow][startCol-1]
				&& board[startRow][startCol-1] ==  word.charAt(1))	{
			suc = suc || go(board, m, n, startRow, startCol-1, word.substring(1), gone);
		}
		
		//向下
		if(startRow < m-1 && !gone[startRow+1][startCol]
				&& board[startRow+1][startCol] ==  word.charAt(1))	{
			suc = suc || go(board, m, n, startRow+1, startCol, word.substring(1), gone);
		}
		//向上
		if(startRow > 0 && !gone[startRow-1][startCol]
				&& board[startRow-1][startCol] ==  word.charAt(1))	{
			suc = suc || go(board, m, n, startRow-1, startCol, word.substring(1), gone);
		}
		gone[startRow][startCol]=false;
		return suc;
	}
}

