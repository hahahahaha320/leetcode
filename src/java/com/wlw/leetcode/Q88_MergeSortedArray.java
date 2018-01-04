package com.wlw.leetcode;

import java.util.Arrays;
import java.util.Date;

import com.wlw.leetcode.util.Util;

public class Q88_MergeSortedArray {

	public static void main(String[] args) {
		Q88_MergeSortedArray test = new Q88_MergeSortedArray();
		
		Date start = new Date();
		
		int[] nums1 = new int[]{1,3,5,7,9,10,11,12};
		int[] nums2 = new int[]{2,4,6};
		test.merge(nums1,2,nums2,3);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		Util.printArray(nums1);
	}
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = Arrays.copyOf(nums1,m);
        for(int i=0,j=0,k=0;i<m+n;i++)	{
        	if(j == m)	{
        		nums1[i] = nums2[k++];
        		continue;
        	} else if(k == n) {
        		nums1[i] = nums3[j++];
        		continue;
        	}
        	if(nums2[k] <= nums3[j])	{
        		nums1[i] = nums2[k++];
        	} else {
        		nums1[i] = nums3[j++];
        	}
        }
    }
}

