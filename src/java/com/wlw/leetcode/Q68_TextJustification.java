package com.wlw.leetcode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Q68_TextJustification {

	public static void main(String[] args) {
		Q68_TextJustification test = new Q68_TextJustification();
		
		Date start = new Date();
		
		String[] words = new String[]{"What","must","be","aabbcceef","sabc","b","c"};
//		String[] words = new String[]{"a","b","c","d","e"};
		List<String> result = test.fullJustify(words,12);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
		for(String str : result)	{
			System.out.println(str.length());
		}
	}
	
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> result = new ArrayList<String>();
		if(maxWidth == 0 || words.length == 1)	{
			result.add(packSum(words, 0, 0, maxWidth));
			return result;
		}
		int addLength = 0;
		int start = 0;
        for(int i=0;i<words.length;i++)	{
        	int nextLength;
        	if(i == words.length-1)	{
        		nextLength = 0;
        	} else {
        		nextLength = words[i+1].length();
        	}
        	addLength = addLength+1+words[i].length();
        	if(addLength+nextLength > maxWidth)	{
        		result.add(packSum(words,start,i,maxWidth));
        		start = i+1;
        		addLength = 0;
        	}
        }
        if(addLength > 0)	{
        	String line = "";
        	for(int i=start;i<=words.length-1;i++)	{
        		line = line+words[i]+" ";
        	}
        	result.add(line.trim()+makeSpace(maxWidth-line.trim().length()));
        }
        return result;
    }
	private String packSum(String[] words,int start,int end,int maxWidth)	{
		int totalLen = 0;
		for(int i=start;i<=end;i++)	{
			totalLen = totalLen+words[i].length();
		}
		int spaceCount = end-start;
		if(spaceCount == 0)	{
			spaceCount = 1;
		}
		
		if(start == end)	{
			return words[start]+makeSpace(maxWidth-words[start].length());
		}
		String result= "";
		int spaceNum = maxWidth-totalLen;
		int avg = spaceNum/spaceCount;
		int margin = spaceNum-avg*spaceCount;
		for(int i=start;i<=end;i++)	{
			if(i == end)	{
				result = result+words[i];
			} else {
				if(margin>0)	{
					result = result+words[i]+makeSpace(avg+1);
					margin--;
				} else {
					result = result+words[i]+makeSpace(avg);
				}
			}
		}
		return result;
	}
	private String makeSpace(int n)	{
		String result = "";
		for(int i=0;i<n;i++){
			result = result+" ";
		}
		return result;
	}
}

