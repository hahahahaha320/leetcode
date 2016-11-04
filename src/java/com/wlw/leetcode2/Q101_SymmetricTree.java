package com.wlw.leetcode2;

import java.util.Date;

public class Q101_SymmetricTree {

	public static void main(String[] args) {
		Q101_SymmetricTree test = new Q101_SymmetricTree();
		
		Date start = new Date();
		
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(3);
		
		node1.left = node2;
		node1.right = node3;
		
		Object result = test.isSymmetric(node1);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public boolean isSymmetric(TreeNode root) {
		if(root == null)	{
			return true;
		}
		return isMirror(root.left, root.right);
	}
	public boolean isMirror(TreeNode node1,TreeNode node2) {
        if(node1 == null && node2 == null)	{
        	return true;
        } else if(node1 != null && node2 == null || node1 == null && node2 != null)	{
        	return false;
        } else {
        	if(node1.val != node2.val)	{
        		return false;
        	}
        	return isMirror(node1.left,node2.right) &&  isMirror(node1.right,node2.left);
        }
    }
}

