package com.wlw.leetcode;

public class Q01_TwoSum {

	public static void main(String[] args) {
		Q01_TwoSum test = new Q01_TwoSum();
		
		int[] nums = new int[]{3,2,4};
		int target = 6;
		int[] result = test.twoSum(nums, target);
		System.out.println(result);
		for(int i : result)	{
			System.out.println(i+",");
		}

	}
	
	public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i+1,j+1};
                }
            }
        }
        return null;
    }
}

