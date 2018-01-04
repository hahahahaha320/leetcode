package com.wlw.leetcode1;

import java.util.Date;

import com.wlw.leetcode.util.ParamUtil;
import com.wlw.leetcode.util.TreeNode;

public class Q124_BinaryTreeMaximumPathSum2 {
	/**
	 *  容易想到的方法是分别经过root的maxPath，和不经过root的maxPath。然后递归解决。
	 *  用maxPathDown计算以node为顶点，往下垂的一条线的最大值.这样可以极大减小递归里的计算量。
	 * @param args
	 */
	public static void main(String[] args) {
		Q124_BinaryTreeMaximumPathSum2 test = new Q124_BinaryTreeMaximumPathSum2();
		
		String testStr = "1,2,3,4,5,6,7";
		TreeNode root = ParamUtil.str2TreeNode(testStr);
		
		Date start = new Date();
		Object result = test.maxPathSum(root);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	
	int maxValue;
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }
    private int maxPathDown(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}

