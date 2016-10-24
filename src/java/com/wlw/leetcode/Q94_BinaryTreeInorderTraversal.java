package com.wlw.leetcode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Q94_BinaryTreeInorderTraversal {

	public static void main(String[] args) {
		Q94_BinaryTreeInorderTraversal test = new Q94_BinaryTreeInorderTraversal();
		
		Date start = new Date();
		
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		
		Object result = test.inorderTraversal(null);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if(root == null)	{
			return result;
		}
        if(root.left != null)	{
        	result.addAll(inorderTraversal(root.left));
        }
        result.add(root.val);
        if(root.right != null)	{
        	result.addAll(inorderTraversal(root.right));
        }
        return result;
    }
}

