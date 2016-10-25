package com.wlw.leetcode;

import java.util.Date;

public class Q99_RecoverBinarySearchTree {

	public static void main(String[] args) {
		Q99_RecoverBinarySearchTree test = new Q99_RecoverBinarySearchTree();
		
		Date start = new Date();
		TreeNode node1 = new TreeNode(10);
		TreeNode node2 = new TreeNode(5);
		TreeNode node3 = new TreeNode(20);
		TreeNode node4 = new TreeNode(2);
		TreeNode node5 = new TreeNode(7);
		TreeNode node6 = new TreeNode(15);
		TreeNode node7 = new TreeNode(25);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		
		test.recoverTree(node1);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(node1);
	}
	public void recoverTree(TreeNode root) {
        
    }
}

