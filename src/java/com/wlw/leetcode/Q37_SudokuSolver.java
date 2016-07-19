package com.wlw.leetcode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Q37_SudokuSolver {

	public static void main(String[] args) {
		Q37_SudokuSolver test = new Q37_SudokuSolver();
		
		Date start = new Date();
		
		String[] strs = new String[]{
				"53..7....",
				"6..195...",
				".98....6.",
				"8...6...3",
				"4..8.3..1",
				"7...2...6",
				".6....28.",
				"...419..5",
				"....8..79"
		};
		
		char[][] board = new char[9][9];
		for(int i=0;i<9;i++)	{
			for(int j=0;j<9;j++)	{
				board[i][j] = strs[i].charAt(j);
			}
		}
		test.solveSudoku(board);
		
		for(int i=0;i<9;i++)	{
			for(int j=0;j<9;j++)	{
				if(board[i][j]<='9' && board[i][j]>='0'){
					System.out.print(board[i][j]+",");
				} else {
					System.out.print("("+(int)board[i][j]+"),");
				}
			}
			System.out.println();
		}
		Q36_ValidSudoku q36 = new Q36_ValidSudoku();
		boolean result = q36.isValidSudoku(board);
		System.out.println("q36 result: " + result);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
	}
	
	
	public void solveSudoku(char[][] board) {
		List<Node> list = new ArrayList<Node>();
		for(int i=0;i<9;i++)	{
			for(int j=0;j<9;j++)	{
				if(board[i][j] == '.')	{
					list.add(new Node(i,j));
				}
			}
		}
		int cur = 0;
		while(cur < list.size())	{
			Node curNode = list.get(cur);
			for(char i=(++curNode.val);i<=':';i++)	{
				if(i==':')	{
					curNode.val = '0';
					board[curNode.m][curNode.n] = '.';
					cur--;
					break;
				}
				if(check(board,curNode.m,curNode.n,i))	{
					curNode.val = i;
					board[curNode.m][curNode.n] = i;
					cur++;
					break;
				}
			}
		}
    }
	boolean check(char[][] board, int m,int n,char a) {
	    for (int k=0; k<9; ++k) {
	        int x = m/3*3 + k/3, y = n/3*3 + k%3;
	        if ( board[k][n] == a || board[m][k] == a || board[x][y] == a )
	            return false;
	    }
	    return true;
	}
	public class Node	{
		int m;
		int n;
		char val = '0';
		public Node(int m,int n)	{
			this.m = m;
			this.n = n;
		}
	}
}

