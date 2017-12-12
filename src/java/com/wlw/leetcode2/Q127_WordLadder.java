package com.wlw.leetcode2;

import java.util.Date;
import java.util.List;

public class Q127_WordLadder {

	public static void main(String[] args) {
		Q127_WordLadder test = new Q127_WordLadder();
		
		String beginWord = "hit";
		String endWord = "cog";
		String str = ""+/**~{*/""
				+ "[\"hot\",\"dot\",\"dog\",\"lot\",\"log\",\"cog\"]"
			+ "\r\n"/**}*/;
		List<String> wordList = ParamUtil.str2List(str);
		
		Date start = new Date();
		Object result = test.ladderLength(beginWord,endWord,wordList);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return 0;
    }
}

