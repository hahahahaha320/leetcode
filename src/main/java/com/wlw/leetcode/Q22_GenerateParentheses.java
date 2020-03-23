package com.wlw.leetcode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Q22_GenerateParentheses {

	public static void main(String[] args) {
		Q22_GenerateParentheses test = new Q22_GenerateParentheses();
		
		Date start = new Date();
		
		List<String> result = test.generateParenthesis(1);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
		System.out.println(result.size());
	}
	public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        generate(n,n,"",result);
        return result;
	}
	
	//问题解的个数叫卡特兰数
	//长度为2n的合法排列，第1到2n个位置都满足如下规则：左括号的个数大于等于右括号的个数。
	public void generate(int leftNum,int rightNum,String s,List<String> result)	{
		if(leftNum==0&&rightNum==0)  {
			 result.add(s);
		}
		if (leftNum > 0) {
			generate(leftNum - 1, rightNum, s + '(', result);
		}
		if (rightNum > 0 && leftNum < rightNum) {
			generate(leftNum, rightNum - 1, s + ')', result);
		}
	}
}

