package com.wlw.leetcode1;

import java.util.Date;

import com.wlw.leetcode.util.ParamUtil;
import com.wlw.leetcode.util.TreeNode;

public class Q124_BinaryTreeMaximumPathSum {

	public static void main(String[] args) {
		Q124_BinaryTreeMaximumPathSum test = new Q124_BinaryTreeMaximumPathSum();
		
		String testStr = "1,2,3,4,5,6,7";
		TreeNode root = ParamUtil.str2TreeNode(testStr);
		
		Date start = new Date();
		Object result = test.maxPathSum(root);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public int maxPathSum(TreeNode root) {
        if(root.left == null && root.right == null)	{
			return root.val;
		}
        int leftMaxPath;
        if(root.left == null)	{
        	leftMaxPath = Integer.MIN_VALUE;
        } else {
        	leftMaxPath = maxPathSum(root.left);
        }
        int rightMaxPath;
        if(root.right == null)	{
        	rightMaxPath = Integer.MIN_VALUE;
        } else {
        	rightMaxPath = maxPathSum(root.right);
        }
		int maxPathNotRoot = Math.max(leftMaxPath,rightMaxPath);
		
		int leftMaxLeg = maxLeg(root.left);
		int rightMaxLeg = maxLeg(root.right);
		int maxPathWithRoot = root.val;
		if(leftMaxLeg > 0)	{
			maxPathWithRoot += leftMaxLeg;
		}
		if(rightMaxLeg > 0)	{
			maxPathWithRoot += rightMaxLeg;
		}
		Integer result = Math.max(maxPathNotRoot,maxPathWithRoot);
		return result;
    }
	private int maxLeg(TreeNode node)	{
		if(node == null)	{
			return Integer.MIN_VALUE;
		}
		if(node.left == null && node.right == null)	{
			return node.val;
		}
		int maxLeg = Math.max(maxLeg(node.left),maxLeg(node.right))+node.val;
		maxLeg = Math.max(maxLeg,node.val);
		return maxLeg;
	}
}

