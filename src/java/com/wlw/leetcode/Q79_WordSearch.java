package com.wlw.leetcode;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Q79_WordSearch {

	public static void main(String[] args) {
		Q79_WordSearch test = new Q79_WordSearch();
		
		Date start = new Date();
		
		char[][] board = new char[][]{  {'A','B','C','E'},
				  						{'S','F','E','S'},
				  						{'A','D','E','E'}};
		//SEE  ABCB
		Object result = test.exist(board,"A");

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
        			Set<Integer> gone = new HashSet<Integer>();
            		suc = suc || go(board, m, n, i, j, word, gone);
            	}
        	}
        }
        return suc;
    }
	
	public boolean go(char[][] board,int m,int n,int startRow,int startCol,String word,Set<Integer> gone)	{
		if(word.length() == 1 && board[startRow][startCol] == word.charAt(0))	{
			return true;
		}
		if(board[startRow][startCol] != word.charAt(0))	{
			return false;
		}
		gone.add(startRow*n+startCol);
		
		boolean suc = false;
		//向右
		if(startCol < n-1 && !gone.contains(startRow*n+startCol+1)
				&& board[startRow][startCol+1] ==  word.charAt(1))	{
			suc = suc || go(board, m, n, startRow, startCol+1, word.substring(1), gone);
		}
		//向左
		if(startCol > 0 && !gone.contains(startRow*n+startCol-1)
				&& board[startRow][startCol-1] ==  word.charAt(1))	{
			suc = suc || go(board, m, n, startRow, startCol-1, word.substring(1), gone);
		}
		
		//向下
		if(startRow < m-1 && !gone.contains((startRow+1)*n+startCol)
				&& board[startRow+1][startCol] ==  word.charAt(1))	{
			suc = suc || go(board, m, n, startRow+1, startCol, word.substring(1), gone);
		}
		//向上
		if(startRow > 0 && !gone.contains((startRow-1)*n+startCol)
				&& board[startRow-1][startCol] ==  word.charAt(1))	{
			suc = suc || go(board, m, n, startRow-1, startCol, word.substring(1), gone);
		}
		gone.remove(startRow*n+startCol);
		return suc;
	}
}

