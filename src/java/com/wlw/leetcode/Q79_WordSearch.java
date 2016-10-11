package com.wlw.leetcode;

import java.util.Date;

public class Q79_WordSearch {

	public static void main(String[] args) {
		Q79_WordSearch test = new Q79_WordSearch();
		
		Date start = new Date();
		
		char[][] board = new char[][]{  {'A','B','C','S'},
				  						{'B','F','C','E'},
				  						{'C','S','E','E'}};
		//SEE  ABCB
		Object result = test.exist(board,"ABCCES");

		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public boolean exist(char[][] board, String word) {
		int m=board.length;
        int n=board[0].length;
        int end = m*n-1;
        int pos = 0;
        for(int k=0;k<=end;k++)	{
        	int i = k/n;
        	int j = k-n*i;
        	if(board[i][j] == word.charAt(pos))	{
        		pos++;
        		if(pos == word.length())	{
        			return true;
        		}
        	}
        }
        return false;
    }
}

