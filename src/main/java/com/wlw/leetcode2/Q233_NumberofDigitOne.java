package com.wlw.leetcode2;

import java.util.Date;

public class Q233_NumberofDigitOne {
	private static long totalCount = 0;
	public static void main(String[] args) {
		Q233_NumberofDigitOne test = new Q233_NumberofDigitOne();
		
		Date start = new Date();
		
//		for(int i=0;i<99999;i++)	{
//			int result = test.countDigitOne(i);
//			int resultRight = test.countDigitOne2(i);
//			if(resultRight != result)	{
//				System.out.println("error:"+ i);
//				System.out.println("right answer:"+ resultRight+",result:"+result);
//			}
//		}
//		answer:1737167499,
//		result:551071949
		//	   900000000
		//	   1410065408
		int m = 1410065408;
		int result = test.countDigitOne(m);
		int resultRight = test.countDigitOne2(m);
		System.out.println("right answer:"+ resultRight+",result:"+result);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime())+",totalCount:"+totalCount);
	}
	public int countDigitOne2(int n) {
		int result = 0;
		for(int i=1;i<=n;i++)	{
			result += num(i);
		}
        return result;
    }
	public int countDigitOne(int n) {
        int digitNum = 0;
        int m=n;
        while(m>0)	{
        	m=m/10;
        	digitNum++;
        }
        int[] oneNumArr = new int[digitNum+1];
        int frontOneNum = 10;
        oneNumArr[0]=0;
        if(digitNum > 1)	{
        	oneNumArr[1]=1;
            for(int i=2;i<=digitNum;i++)	{
            	oneNumArr[i] = oneNumArr[i-1]*10 + frontOneNum;
            	frontOneNum = frontOneNum*10;
            }
        }
        int result = 0;
        int pow = (int)Math.pow(10,digitNum-1);
        m=n;
        while(m>0)	{
        	if(m>=1 && m<=9)	{
        		result++;
        		break;
        	}
        	int firstNum = m/pow;
        	m = m%pow;
        	if(firstNum == 1) {
        		result = result+oneNumArr[digitNum-1] + m+1;
        	} else if(firstNum > 1) {
        		result = result+(firstNum)*oneNumArr[digitNum-1]+pow;
        	}
        	pow = pow /10;
        	digitNum--;
        }
        return result;
    }
	
	
	private int num(int n)	{
		int result = 0;
		while(n>0)	{
			if(n%10 == 1)	{
				result++;
			}
			n = n/10;
		}
		return result;
	}
}

