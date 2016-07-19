package com.wlw.leetcode;

public class Q04_MedianOfTwoSortedArrays {
	public static void main(String[] args) {
		Q04_MedianOfTwoSortedArrays test = new Q04_MedianOfTwoSortedArrays();
		int[] nums1 = new int[]{1,2,7,8};
		int[] nums2 = new int[]{3,4};
		double median = test.findMedianSortedArrays(nums1, nums2);
		System.out.println(median);
		
	}
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		int count = len1+len2;
        int[] mergeNum = new int[count];
		int index1=0;
		int index2=0;
		for(int i=0;i<count;i++)	{
			if(index1 >= len1 ){
				mergeNum[i] = nums2[index2];
				index2++;
				continue;
			} 
			if(index2 >= len2 ){
				mergeNum[i] = nums1[index1];
				index1++;
				continue;
			} 
			
			if(nums1[index1] < nums2[index2])	{
				mergeNum[i] = nums1[index1];
				index1++;
			} else {
				mergeNum[i] = nums2[index2];
				index2++;
			}
		}
		if(count%2==1)	{
			return mergeNum[(count-1)/2];
		} else {
			return (mergeNum[count/2]+mergeNum[count/2-1])/2d;
		}
    }
}
