package com.wlw.leetcode;

import java.util.Date;

public class Q06_ZigZagConversion {

	public static void main(String[] args) {
		Q06_ZigZagConversion test = new Q06_ZigZagConversion();
		
		Date start = new Date();
		
		String str = "PAYPALISHIRING";
		String result = test.convert(str,3);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	
	public String convert(String str, int numRows) {
		if(str.length() < numRows || numRows==1)	{
			return str;
		}
        StringBuffer sb = new StringBuffer();
        int len = str.length();
        int totalAddIndex = (numRows-1)*2;
		for(int i=0;i<numRows;i++)	{
        	int addIndex1=totalAddIndex;
        	int addIndex2=0;
        	if(i < numRows-1)	{
        		addIndex1=totalAddIndex-i*2;
        		addIndex2 = totalAddIndex-addIndex1;
        	}
        	int index = i;
        	sb.append(str.charAt(index));
			while(true)	{
				index = index+addIndex1;
				if(index >= len)	{
					break;
				}
        		sb.append(str.charAt(index));
        		if(addIndex2 > 0)	{
        			index = index+addIndex2;
        			if(index >= len)	{
        				break;
        			}
        			sb.append(str.charAt(index));
        		}
        		
        	}
        }
		return sb.toString();
    }
}

