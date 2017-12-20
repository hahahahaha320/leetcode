package com.wlw.leetcode2;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q212_WordSearchII {

	public static void main(String[] args) {
		Q212_WordSearchII test = new Q212_WordSearchII();
		
		Date start = new Date();
		
		char[][] board = new char[][]{  {'o','a','a','n'},
				  						{'e','t','a','e'},
				  						{'i','h','k','r'},
				  						{'i','f','l','v'}
				  						
		};
		String[] words = new String[]{"oath","pea","eat","rain"};
		Object result = test.findWords(board,words);

		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public List<String> findWords(char[][] board, String[] words) {
		List<String> result = new ArrayList<String>();
		Set<String> dealed = new HashSet<String>();
		for(String word : words)	{
        	if(!dealed.contains(word) && exist(board, word))	{
        		result.add(word);
        	}
        	dealed.add(word);
        }
		return result;
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

