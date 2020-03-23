package com.wlw.leetcode;

import java.util.Arrays;
import java.util.Date;

public class Q31_NextPermutation {

	public static void main(String[] args) {
		Q31_NextPermutation test = new Q31_NextPermutation();
		
		Date start = new Date();
		
		int[] nums = new int[]{4,5,6,3,2,1};//[4,6,1,2,3,5]
		test.nextPermutation(nums);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		for(int i : nums)	{
			System.out.print(i+",");
		}
		
	}
	public void nextPermutation(int[] num) {  
        if(num==null || num.length<=1) {  
            return;  
        }  
        int i=num.length-1;  
        while(i>0 && num[i]<=num[i-1] ) { 
            --i;  
        }  
        Arrays.sort(num, i, num.length);  
        if(i!=0) {  
            int j=i;  
            while(num[i-1]>=num[j]) ++j; 
            swap(num, i-1, j);  
        }  
    }  
    private void swap(int[] a, int x, int y) {  
        a[x] = a[x] ^ a[y];  
        a[y] = a[x] ^ a[y];  
        a[x] = a[x] ^ a[y];  
    }
}

