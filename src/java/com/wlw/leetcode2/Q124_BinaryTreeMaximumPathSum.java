package com.wlw.leetcode2;

import java.util.Date;

public class Q124_BinaryTreeMaximumPathSum {

	public static void main(String[] args) {
		Q124_BinaryTreeMaximumPathSum test = new Q124_BinaryTreeMaximumPathSum();
		
		TreeNode root = new TreeNode(2);
		TreeNode node2 = new TreeNode(-1);
//		TreeNode node3 = new TreeNode(-1);
//		
//		TreeNode node4 = new TreeNode(4);
//		TreeNode node5 = new TreeNode(5);
//		
//		TreeNode node6 = new TreeNode(6);
//		TreeNode node7 = new TreeNode(7);
//		
		root.left = node2;
//		root.right = node3;
//		
//		node2.left = node4;
//		node2.right = node5;
//		
//		node3.left = node6;
//		node3.right = node7;
		
		
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
		int maxPath = Math.max(leftMaxPath,rightMaxPath);
		maxPath = Math.max(maxPath,maxLeg(root.left)+maxLeg(root.right)+root.val);
		return maxPath;
    }
	private int maxLeg(TreeNode node)	{
		if(node == null)	{
			return Integer.MIN_VALUE;
		}
		if(node.left == null && node.right == null)	{
			return node.val;
		}
		int maxLeg = Math.max(maxLeg(node.left),maxLeg(node.right))+node.val;
		return maxLeg;
	}
}

