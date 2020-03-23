package com.wlw.leetcode;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Q36_ValidSudoku {

	public static void main(String[] args) {
		Q36_ValidSudoku test = new Q36_ValidSudoku();
		
		Date start = new Date();
		
		char[][] board = new char[9][9];
		boolean result = test.isValidSudoku(board);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	private boolean isRepeat(Set<Character> set,char ch)	{
		if(ch == '.')	{
			return false;
		}
		if(set.contains(ch))	{
			return true;
		} else {
			set.add(ch);
		}
		return false;
	}
	public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++)	{
        	Set<Character> set = new HashSet<Character>();
        	for(int j=0;j<9;j++)	{
        		if(isRepeat(set,board[i][j]))	{
        			return false;
        		}
        	}
        }
        for(int i=0;i<9;i++)	{
        	Set<Character> set = new HashSet<Character>();
        	for(int j=0;j<9;j++)	{
        		if(isRepeat(set,board[j][i]))	{
        			return false;
        		}
        	}
        }
        
        for(int i=0;i<=6;i=i+3)	{
        	for(int j=0;j<=6;j=j+3)	{
        		Set<Character> set = new HashSet<Character>();
        		for(int k=0;k<9;k++)	{
        			int m = i+k/3;
        			int n = j+k%3;
        			if(isRepeat(set,board[m][n]))	{
            			return false;
            		}
        		}
        	}
        }
        return true;
    }
}

