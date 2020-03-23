package com.wlw.leetcode;

import java.util.ArrayList;
import java.util.Date;

public class Q89_GrayCode2 {

	public static void main(String[] args) {
		Q89_GrayCode2 test = new Q89_GrayCode2();
		
		Date start = new Date();
		Object result = test.grayCode(2);
		
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public ArrayList<Integer> grayCode(int n) {  
        if(n==0) {  
            ArrayList<Integer> result = new ArrayList<Integer>();  
            result.add(0);  
            return result;  
        }  
        ArrayList<Integer> tmp = grayCode(n-1);  
        int addNumber = 1 << (n-1);  
        ArrayList<Integer> result = new ArrayList<Integer>(tmp);  
        for(int i=tmp.size()-1;i>=0;i--) {  
        	result.add(addNumber + tmp.get(i));
        }  
        return result;  
    }  
}

