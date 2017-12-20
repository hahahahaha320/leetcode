package com.wlw.leetcode1;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Q128_LongestConsecutiveSequence2 {
	/**
	 * 此题要求O(n)，所以不能先排序，而题目要求的连续，所以可以使用Set来实现类似排序的效果，用以检查num++是否在set中。
	 * @param args
	 */
	public static void main(String[] args) {
		Q128_LongestConsecutiveSequence2 test = new Q128_LongestConsecutiveSequence2();
		
		Date start = new Date();
		
		int[] nums = new int[]{1,2,8,10,9};
		Object result = test.longestConsecutive(nums);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) {
            numSet.add(num);
        }
        int totalMax = 0;
        for (int num : numSet) {
            if (!numSet.contains(num-1)) {
                int currentNum = num;
                int curMax = 1;
                while (numSet.contains(currentNum+1)) {
                    currentNum += 1;
                    curMax += 1;
                }
                totalMax = Math.max(totalMax, curMax);
            }
        }
        return totalMax;
    }
}

