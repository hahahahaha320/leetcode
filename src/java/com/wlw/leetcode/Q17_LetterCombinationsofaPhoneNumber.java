package com.wlw.leetcode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Q17_LetterCombinationsofaPhoneNumber {
	
	public static void main(String[] args) {
		Q17_LetterCombinationsofaPhoneNumber test = new Q17_LetterCombinationsofaPhoneNumber();
		
		Date start = new Date();
		
		List<String> result = test.letterCombinations("23");
		System.out.println(result);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		
	}
	
	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
        if(digits.contains("0") || digits.contains("1") || digits.length()==0)	{
        	return result;
        }
        int digLength = digits.length();
        if(digLength == 1)	{
        	String str = getStringByDigit(Integer.parseInt(digits));
        	for(int i=0;i<str.length();i++)	{
        		result.add(str.charAt(i)+"");
        	}
        	return result;
        }
        Integer firstNum = Integer.parseInt(digits.charAt(0)+"");
        String firstStr = getStringByDigit(firstNum);
        List<String> subResult = letterCombinations(digits.substring(1));
        for(int i=0;i<firstStr.length();i++)	{
        	char curChar = firstStr.charAt(i);
        	for(String sub : subResult){
        		result.add(curChar+sub);
        	}
        }
        return result;
    }
	private String getStringByDigit(int digit){
		switch (digit) {
		case 2: return "abc";
		case 3: return "def";
		case 4: return "ghi";
		case 5: return "jkl";
		case 6: return "mno";
		case 7: return "pqrs";
		case 8: return "tuv";
		case 9: return "wxyz";
		default: return "";
		}
	}
}
